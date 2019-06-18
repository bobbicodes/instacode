// Compiled by ClojureScript 1.10.516 {}
goog.provide('instacode.core');
goog.require('cljs.core');
instacode.core.set_html_BANG_ = (function instacode$core$set_html_BANG_(el,content){
return el.innerHTML = content;
});
instacode.core.main = (function instacode$core$main(){
var content = "Hello World from ClojureScript";
var element = (document.getElementsByTagName("main")[(0)]);
return instacode.core.set_html_BANG_.call(null,element,content);
});
instacode.core.main.call(null);

//# sourceMappingURL=core.js.map
