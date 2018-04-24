# VisiFile
VisiFile is a desktop app that allows you to find and share local data with others on your intranet. There is demo here: http://139.162.228.5/

You can install VisiFile on any Linux system that supports the Ubuntu Snap package manager with:

    sudo snap install visifile --edge --devmode

VisiFile support the following common document formats, including:
<br>

* Excel
* Word
* CSV
* PDF

<br>

VisiFile is built with:

- Electron
- MoonJS
- Sqlite
- Javascript
- NodeJS 8.9
- Express
- SocketIO

Command line options:

    -h, --help                 output usage information
    -V, --version              output the version number
    -t, --type [type]          Add the specified type of app [type]
    -p, --port [port]          Which port should I listen on? [port]
    -h, --host [host]          Server address of the central host [host]
    -s, --hostport [hostport]  Server port of the central host [hostport]






### Developer quick start


##### 1) Install GIT from https://git-scm.com/downloads
##### 2) Install Node.js 8.9 32 bit installer from https://nodejs.org/en/download/
##### 3) From the command line get the Git repository
    git clone https://github.com/zubairq/visifile.git
##### 4) Go to the VisiFile directory
    cd visifile/visifile
##### 5) Install the NodeJS modules
    npm install
##### 6) Build the VisiFile UI
    npm run build
##### 7) Run the VisiFile NodeJS application
    node src\electron.js

### If you wish to live edit the UI of VisiFile in realtime then you need the following additional steps

##### 8) Type into the command line:
    npm run dev

##### 9) From a web browser open
    http://localhost:8080/public/

##### 10) Go to the file visifile\src\components\App.vue

##### 11) Change the text "Browse Data" to "Live Editing"

##### 12) When you save the file then your changes should be updated in real time in the browser



### What is VisiFile's killer feature?

VisisFile's killer feature is being able to see a many different data sources in one place



### Is there commercial support for VisiFile?
If you require commercial support then please go to http://visifile.com
