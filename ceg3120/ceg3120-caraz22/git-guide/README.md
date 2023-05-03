# Git Guide
This is guide to using GitHub and git commands.

## Some important vocabulary
* index
    * An area that stands between your local files and your commits
* local
    * On your actual system
* remote 
    * On a server, in which this case is GitHub
* working tree
    * A tree like structure of files and directories
* branch
    * An independent part of your repository
    * Think of it as a branch of a (working) tree
* tracking
    * Having a connection between the local branch and the remote branch
* history
    * A log of commits made in the repository starting from the most recent commit
* head
    * The current commit/branch that you are viewing/in

## git on the command line
* status 
    * Shows the status of the working tree
        * Displays any differences between index files and files that are the latest commit of the branch
        * Displays files that are not being tracked
        * Displays files that are able to be added and committed 
    * `git status`
* clone
    * Makes a copy of a repository and turns it into a local directory that tracks for each branch cloned
    * `git clone <repo>`
* add
    * Adds a file to the index
    * Must be used before running the commit command
    * `git add <file(s)>`
* rm
    * Removes files from the working tree and index 
    * `git rm <file(s)>`
* commit
    * An instance of changes to a file or files
    * Must come with a message describing the changes that were made
    * `git commit`
* push
    * Updates the remote repository with changes made to files that have been committed
    * `git push`
* fetch
    * Downloads things from another repository including:
        * branches
        * tags
        * objects 
            * These come along with branches and/or tags and are necessary to complete their histories
    * `git fetch <repo>`
* merge
    * Takes two or more independent development histories and puts them together into one branch
    * `git merge <branch>`
* pull
    * Takes changes in the remote repository and incorporates them into the current local branch
    * `git pull`
* branch
    * Displays all local branches
        * Using the flag `-r` will display all remote branches
        * Using the flag `-a` will display all of both local and remote branches
    * `git branch`
* checkout
    * Switches from the current branch to the specified branch
    * Updates working tree to match the specified branch
    * `git checkout <branch>`
* init
    * Creates a new Git repository
    * `git init <name>`
* remote
    * Helps you manage your connections to remote repositories by:
        * Creating a connection
        * Viewing a connection
        * Deleting a connection
    * `git remote`


## git files & folders
* .git folder
    * A folder that is required to log every commit history and any other information that is needed for your repository, version control, and of course, commits
    * Typically contains the following folders:
        * hooks - a folder with scripts named Git hooks, which are scripts that are executed in response to specific events in your repository
        * info - contains the exclude file, which contains specific patterns in code that you don't want Git to recognize or use
        * objects - everything saved in this folder is saved as a hash value, including every commit, tree, or file that was created
    * ...and these files:
        * config - contains the configuration (what a surprise!) that has been set for your repository, like your username and email
        * HEAD - contains the reference to the branch that is currently being worked on
* .gitignore file
    * A plain text file that contains names to untracked files that are to remain untracked by Git
    * Files that are already being tracked are unaffected

## GitHub
* Pull requests
    * Used when a user wants to share any changes that have been pushed to a branch of a repository in GitHub
    * Once opened, those who are collaborating with you can see these changes before they are merged 
    * This makes this mainly useful for projects that you are working on with others, rather than on your own
* SSH authentication to repositories
1. Use the following command format: `ssh-keygen -t ed25519 -C "<email of GitHub account>"`
2. Save the newly made keys into a folder, default /.ssh is fine
3. `cd` into the folder where the keys were saved and `cat` or `vim` the public key file and copy the contents
4. Go to your settings on your GitHub account and make your way to the SSH and GPG keys tab
5. Create a new SSH key using a relevant name and the contents of your public key file
6. Once the SSH key is created, go to the repository that you want to clone and copy the given SSH key for your repository under the "<> Code" button
7. Go back to your terminal and use the following command format: `git clone <password-protected SSH key>`
8. Given everything was done correctly, you have now cloned your repository onto your local system

## Resources
* The `man` command
* [Dot Git Folder](https://www.toolsqa.com/git/dot-git-folder/#:~:text=A%20.,the%20contents%20of%20the%20folder.)
* [About pull requests](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests)
