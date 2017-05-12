# BerlinClock
An example of the implementation of the Berlin Clock in Scala, using ASCII art


To view a Berlin Clock as ASCII art, enter a time as string of the format HH:mm:ss

For example:

    $ sbt "run 17:33:22"

will produce:

             | Y |
    -----------------------
    | R  |  R  |  R  |  _ |
    -----------------------
    | R  |  R  |  _  |  _ |
    -----------------------
    |Y|Y|R|Y|Y|R|_|_|_|_|_|
    -----------------------
    | Y  |  Y  |  Y  |  _ |
    -----------------------
