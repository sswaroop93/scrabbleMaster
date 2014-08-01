scrabbleMaster
==============


It reads a set of words from a file and outouts the highest scoring word that is present in the sowpods dictionary.

For 7 tiles (letters), it forms words using the specifies 7 letter or less. For 6 given tiles and an empty one, it may use an arbitary letter with zero score.

Flow of the code:
-----------------------

1) Read the Sowpods dictionary 
2) iterate over the sowpods wordList to check if the word can be made from the given rack of characters
3) If  word can be  formed compute score and update the maximum score
4) Prints the maximum Score and the word with Max Score.
