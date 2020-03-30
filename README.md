# Game Maker Studio Soundtrack Extractor
This little tool was mainly just written so I can rip some game's Soundtrack I liked a lot. So decided to make it public if it might come useful to others someday... 

## How it works:
There is no black magic involved really.., I've found that GMS stores the assets nearly raw in their packers (data.win etc). Each asset come in their own container, for Soundtracks apparently it's AUDO (I'm assuming it's abbreviated from Audio). Next 4 bytes tells me how big that container within the file, so if I had 2 5megs big soundtrack files it would say something around 10megs. Next integer tells me how many soundtrack files I have. Next 4 bytes tell me on which offset in the file those soundtrack files are located. On that offset comes another 4 byte telling me how big that file is. 
From my case I've found only regular wave files, so I just assumed they're like, though I can imagine that other file type could be also inside. In my current code I export with .wav extension, though if I find that it uses also other format types I might change that.

For short: My program just linearly searches for the AUDO sequence inside the given file. Once found, it notes down where the offsets are and just copies those soundtrack files byte after byte out.
