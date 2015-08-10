(function(window) {
    "use strict";

    // stub the bridge if it does not exist for debugging
    if (!window.jsBridge) {
        // create mock obj
        function stub(obj, functionName) {
            obj[functionName] = function () {
                console.log("bridge: " + functionName);
            }
        }
        window.jsBridge = {};
        stub(window.jsBridge, "showTableOfContents");
        stub(window.jsBridge, "onVideoEnd");
        stub(window.jsBridge, "onNextVideo");
        stub(window.jsBridge, "onPreviousVideo");
    }
})(window);

