(function() {
    "use strict";

    var player = videojs("main-video", { /* options */ }, function () {

        console.log("loading video");

        this.play(); // autoplay

        this.on("ended", function () {
            jsBridge.onVideoEnd();
        });

    });

})();