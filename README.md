# How this works

This library is designed to make your life really easy, so this needs to be super-clear or it will be self-defeating.

1. Clone this repo
2. Start a repl from its directory
3. Type `(nb "title" "code")`.

That's right, just paste your entire code (inside quotes) right into the repl. If you leave out the title it will default to `index.html`.

Open your file!

# Why I made this

My favorite way to write Clojure code is in KLIPSE snippets, because the code is being constantly evaluated with the current result being displayed while you are editing it. **This is super useful!**

I actually write all of my code in these snippets, effectively turning the browser into a quick and dirty IDE. I just needed to streamline the process of generating the pages to allow for a decent workflow.

# Bugs

Can't do any metadata, because the `^` character breaks it. Probably other gotchas as well...
 