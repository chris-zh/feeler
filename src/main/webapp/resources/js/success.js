YUI({
    classNamePrefix: 'pure'
}).use('gallery-sm-menu', function (Y) {

    var horizontalMenu = new Y.Menu({
        container         : '#horizontal-menu',
        sourceNode        : '#std-menu-items',
        orientation       : 'horizontal',
        hideOnOutsideClick: false,
        hideOnClick       : false
    });

    horizontalMenu.render();
    horizontalMenu.show();

});

f = function() {
    if (typeof pagedown_converter === "undefined")
        pagedown_converter = Markdown.getSanitizingConverter().makeHtml;
    var textarea = document.getElementById("content");
    var preview = document.getElementById("page-down-content");
    textarea.onkeyup = function() { preview.innerHTML = pagedown_converter(textarea.value); }
    textarea.onkeyup.call(textarea);
}
// if (document.readyState === 'complete')
//     f();
// else if (window.addEventListener)
//     window.addEventListener("load", f, false);
// else if (window.attachEvent)
//     window.attachEvent("onload", f);
// else
//     f();