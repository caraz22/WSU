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
This one sucked!!!!!!!!!!!!! I started off following the hint in the instructions, where it says to make a directory inside of the /tmp folder. I then changed directories into the the folder I created. From there, I used the following command:
```
cat /home/bandit12/data.txt | xxd -r > data
```
I took the data.txt file, did a hex dump and put it in a file named data. The next parts are very repetitive. I used the `file` command on the `data` file. This happens multiple times, for different data files distinctive by numbers. The data type returned was either `gzip`, `bzip2`, or `tar`. For each one, I did their respective decompress commands until I got the text file (data8) that gave me the password, "wbWdlBxEir4CaE8LaPhauuOo6pwRmrDw"
## Level 13 --> Level 14
```
ssh -i sshkey.private bandit14@localhost -p 2220
```
The private key was given to use, and the directions tell you that you need to be user bandit14 and that localhost is the host name. I did it first without the `-p 2220` because I had forgotten that is what port we have been using to connect to each level. Used `cat /etc/bandit_pass/bandit14` to get the password, "fGrHPx402xGC7U7rXKDaxiWFTOiF0ENq"
## Level 14 --> Level 15
```
nc localhost 30000
```
Directions stated that the password would be on port 30000 for localhost. Did a netcat, pasted the password from the previous level, and there it is (the password)! "jN2kgmIXJ6fShzhT2avhotn4Zcka6tnt"
## Level 15 --> Level 16
```
openssl s_client -connect localhost:30001 -ign_eof
```
In the directions, under the "Commands you may need to solve this level", there was `openssl` and `s_client`. I have never used those commands so I had to do some research. The port 30001 and localhost was given in the directions as well. After using the command, I pastged the password given from the previous level, and was given the password, which is "JQttfApK4SeyHwDlI9SXGR50qclOAil1"
## Level 16 --> Level 17
```
nmap -p 31000-32000 localhost
```
I learned today that you can scan a range of ports using `-p`! localhost was again given to us for this level. After running the above command, I found 5 ports. To check which port is the one we are looking for, I used the following command:
```
openssl s_client -connect localhost:<port> -quiet
```
From there, I pasted the password given from the previous level. I did this for each port until I found the right one (31790). I was given a private RSA key. I had to do what I did for level 12 and create a directory inside of /tmp so that I could write to a file. I created the file `private-rsa` and pasted the contents of the private key into it. I also had to change the permissions on the file using `chmod 600`
```
ssh -i private-rsa bandit17@localhost -p 2220
```
To find the password, I went into the /etc/bandit_pass folder and used `cat` on the bandit17 file. The password is "VwOSWtCA7lRKkTfbr2IDh6awj9RNZM5e"
## Level 17 --> Level 18
```
diff passwords.old passwords.new
```
The directions say that the password is the only line that has been changed between passwords.old and passwords.new. `diff` gave me two passwords. The first one was the one in passwords.old that was changed, the second one is the new password that it was changed to, which is "hga5tuuCLF6fFzUpnagiMN8ssu9LFrdg"
## Level 18 --> Level 19
```
ssh bandit18@bandit.labs.overthewire.org -p 2220 -t "/bin/sh"
```
Without the `-t "/bin/sh"`, you cannot connect. The directions say that the `.bashrc` file has been modified to log you out when using `ssh`. I got "/bin/sh" from using `cat` on /etc/shells. Using `-t` lets you specify what shell is being used when logging in. Since bash was not allowed, I used sh. The password is "awhqfNnAbc1naukrpqDYcF95h7HoMTrC"
## Level 19 --> Level 20
I saw that there was an executable file, so I used `./bandit20-do`. It told me that I need to run the command as another user, for example `./bandit20-do id`. When I used that command, I found that by executing that file I was given the uid for bandit20. Since I can now run commands as bandit20, I can read the bandit20 password file. From here, I just used:
```
./bandit20-do cat /etc/bandit_pass/bandit20
```
The password is "VxCazJaVykI6W36BkBU0mJTCM8rR95XT"
## Level 20 --> Level 21
Found another executable file, so I used `./suconnect`. It told me a different way to run the command. I just add a port number at the end, and then it will connect to said port using TCP. So, I set up netcat using 
```
nc -lp  9999
```
(did not finish)