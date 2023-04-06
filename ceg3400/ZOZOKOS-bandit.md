# Bandit
## Level 0
```
ssh bandit0@bandit.labs.overthewire.org -p 2220
```
`bandit0@bandit.labs.overthewire.org` to sign in as the user "bandit0"   
`-p 2220` to use port 2220 specifically
## Level 0 --> Level 1
Use `cat` on the readme file. File contains the password, "NH2SXQwcBdpmTEzi3bvBHMM9H66vVXjL", for signing in as bandit1. `exit` and execute the same command from level 0 but as "bandit1" instead of "bandit2"
## Level 1 --> Level 2
```
cat ./-
```
To cat a file named `-`, you need to use the full path because just `-` does not refer to the contents of itself. Using the full path gives you the password "rRGizSaX8Mk1RTb1CNQoXTcYZWU6lgzi". `exit` and move on.
## Level 2 --> Level 3
Use `cat` on the "spaces in this filename" file. When referring to the file, you have to use quotes, otherwise it uses the spaces to separate each word into a different argument. The password for bandit3 is "aBZ0W5EmUfAf7kHTQeOwd8bauFJ2lAiG"
## Level 3 --> Level 4
`cd` into the inhere directory. The file with the password for bandit4 is in a hidden file named ".hidden", which can only be found by using `ls -a`, with the "-a" being there to show hidden files. The password is "2EW7BBsr6aMMoJ2HjW067dm8EgX26xNe"
## Level 4 --> Level 5
`cd` into the inhere directory. There will be 9 files, with only one of them being human readable. I just used `cat` on each file until I found one that didn't look like gibberish. I'm sure there's a more convenient way, but I can't think of what it'd be right now, and I wasted time getting nowhere on Leviathan so I'm trying to fly through these!!!!!!! Password is "lrIWWI6bB37kxfiCQZqUdOIYfr6eEeqR"
## Level 5 --> Level 6
```
find -size 1033c -readable
```
`find` to search multiple directories, `-size` to specify the size of the file, `1033c` as the specified 1033 bytes, `-readable` to ensure it is human readable. The password inside the said file is "P4L4vucdmLnm8I7Vl7jG1ApGSfjYKqJU"
## Level 6 --> Level 7
```
find / -size 33c
```
Same meaning as the command in level 5 --> level 6, but the `/` starts the search from the root directory. Had to search through the list of files that were returned to me, found one named "/var/lib/dpkg/info/bandit7.password" (awfully suspicious), password is "z7WtoNQU2XfjmMtWA8u5rN4vzqu4v99S"
## Level 7 --> Level 8
```
cat data.txt | grep millionth
```
Used `grep` on millionth, the password comes up with it. Super simple! The password is "TESKZC0XvTetK0S9xNwm25STk5iWrBvP"
## Level 8 --> Level 9
```
cat data.txt | sort | uniq -c
```
Used `sort` to put the lines of duplicates next to each other so that they are recognized as duplicates, then used `uniq` to find each line without their duplicates, and `-c` to show how many times each line is repeated. The password was next to count one, which is "EN632PlfYiZbn3PhVK3XOGSlNInNE00t"
## Level 9 --> Level 10
```
strings data.txt | grep =
```
`strings` shows the human readable text of a file, I then used `grep` to find all the human readable lines that have "=" in them, found the password at the bottom, preceded by lines that said "password" and "is". Password is "G7w8LIi6J3kTb8A7j9LgrywtEUlyyp6s"
## Level 10 --> Level 11
``` 
cat data.txt | base64 -d
```
Piping reading the data.txt file with a command that (`-d) decodes a file that is in (`base64`) base 64. Password is "6zPeziLdR2RKNdNYFNb6nVCKzphlXHBM"
## Level 11 --> Level 12
I read the data.txt file using `cat`, took the contents and copied and pasted it into cyberchef. It uses ROT13, the password is "JVNBBFSmZwKKOP0XbFXOoW8chDz5yVRv"
## Level 12 --> Level 13
