(function() {
    if (typeof window.CustomEvent === 'function') return false;
    function CustomEvent(event, params) {
        params = params || {bubbles: false, cancelable: false, detail: null};
        var e = document.createEvent('CustomEvent');
        e.initCustomEvent(event, params.bubbles, params.cancelable, params.detail);
        return e;
    }
    window.CustomEvent = CustomEvent;
})();

