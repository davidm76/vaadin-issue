# Project Base for Vaadin Flow and Spring Boot

This project demonsttaits an issue using Vaadin Flow in conjunction with Posting of Multipart files.

This is that standard skeleton Spring Boot Vaadin Flow started with a test controller added.

Run application using
`mvn spring-boot:run`

Open http://localhost:8080/ in browser to show the Vaadin part works.


This project also has a Rest Controller with 3 end points:


`/get`

```java

    @GetMapping("/get")
    public String doGet() {

        return "Get works";
    }
```

Test like this:

```bash

$ curl http://localhost:8080/get
Get works%

```

A post mapping.
```java

    @PostMapping("/test")
    public String doTest(@RequestBody MyModel myModel) {


        return  myModel.getHello() + " " + myModel.getWorld();
    }

```
 
 Test like this:
 
```bash
$ curl -H "Content-Type: application/json" -X POST -d '{"hello":"Hello","world":"Vaadin"}' http://localhost:8080/test
Hello Vaadin%
```


All good, but if you tru and post a multi-part form to an endpoint like ths:

```java
    @PostMapping("/import")
    public String doPost(@RequestParam("file") MultipartFile file) {


        return  file.getName();
    }
```
Test like this:

```bash
curl -i -X POST -H "Content-Type: multipart/form-data" -F "file=@pom.xml" http://localhost:8080/import

```

Yuo get the following response back:

```html

<!doctype html><html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><meta http-equiv="X-UA-Compatible" content="IE=edge"><base href="."><style type="text/css">body {margin:0;}.v-reconnect-dialog {position: absolute;top: 1em;right: 1em;border: 1px solid black;padding: 1em;}.v-system-error {color: red;background: white;position: absolute;top: 1em;right: 1em;border: 1px solid black;padding: 1em;z-index: 10000;}</style><script type="text/javascript">//<![CDATA[
(function(e){function f(a,c){function b(a){if(!this||this.constructor!==b)return new b(a);this._keys=[];this._values=[];this._itp=[];this.objectOnly=c;a&&v.call(this,a)}c||w(a,"size",{get:x});a.constructor=b;b.prototype=a;return b}function v(a){this.add?a.forEach(this.add,this):a.forEach(function(a){this.set(a[0],a[1])},this)}function d(a){this.has(a)&&(this._keys.splice(b,1),this._values.splice(b,1),this._itp.forEach(function(a){b<a[0]&&a[0]--}));return-1<b}function m(a){return this.has(a)?this._values[b]:void 0}function n(a,c){if(this.objectOnly&&c!==Object(c))throw new TypeError("Invalid value used as weak collection key");if(c!=c||0===c)for(b=a.length;b--&&!y(a[b],c););else b=a.indexOf(c);return-1<b}function p(a){return n.call(this,this._values,a)}function q(a){return n.call(this,this._keys,a)}function r(a,c){this.has(a)?this._values[b]=c:this._values[this._keys.push(a)-1]=c;return this}function t(a){this.has(a)||this._values.push(a);return this}function h(){(this._keys||0).length=this._values.length=0}function z(){return k(this._itp,this._keys)}function l(){return k(this._itp,this._values)}function A(){return k(this._itp,this._keys,this._values)}function B(){return k(this._itp,this._values,this._values)}function k(a,c,b){var g=[0],e=!1;a.push(g);return{next:function(){var f,d=g[0];!e&&d<c.length?(f=b?[c[d],b[d]]:c[d],g[0]++):(e=!0,a.splice(a.indexOf(g),1));return{done:e,value:f}}}}function x(){return this._values.length}function u(a,c){for(var b=this.entries();;){var d=b.next();if(d.done)break;a.call(c,d.value[1],d.value[0],this)}}var b,w=Object.defineProperty,y=function(a,b){return isNaN(a)?isNaN(b):a===b};"undefined"==typeof WeakMap&&(e.WeakMap=f({"delete":d,clear:h,get:m,has:q,set:r},!0));"undefined"!=typeof Map&&"function"===typeof(new Map).values&&(new Map).values().next||(e.Map=f({"delete":d,has:q,get:m,set:r,keys:z,values:l,entries:A,forEach:u,clear:h}));"undefined"!=typeof Set&&"function"===typeof(new Set).values&&(new Set).values().next||(e.Set=f({has:p,add:t,"delete":d,clear:h,keys:l,values:l,entries:B,forEach:u}));"undefined"==typeof WeakSet&&(e.WeakSet=f({"delete":d,add:t,clear:h,has:p},!0))})("undefined"!=typeof exports&&"undefined"!=typeof global?global:window);//]]></script><script type="text/javascript">!function(e){var r=e.babelHelpers={};r.typeof="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},r.classCallCheck=function(e,r){if(!(e instanceof r))throw new TypeError("Cannot call a class as a function")},r.createClass=function(){function e(e,r){for(var t=0;t<r.length;t++){var n=r[t];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(e,n.key,n)}}return function(r,t,n){return t&&e(r.prototype,t),n&&e(r,n),r}}(),r.defineEnumerableProperties=function(e,r){for(var t in r){var n=r[t];n.configurable=n.enumerable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(e,t,n)}return e},r.defaults=function(e,r){for(var t=Object.getOwnPropertyNames(r),n=0;n<t.length;n++){var o=t[n],i=Object.getOwnPropertyDescriptor(r,o);i&&i.configurable&&void 0===e[o]&&Object.defineProperty(e,o,i)}return e},r.defineProperty=function(e,r,t){return r in e?Object.defineProperty(e,r,{value:t,enumerable:!0,configurable:!0,writable:!0}):e[r]=t,e},r.extends=Object.assign||function(e){for(var r=1;r<arguments.length;r++){var t=arguments[r];for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])}return e},r.get=function e(r,t,n){null===r&&(r=Function.prototype);var o=Object.getOwnPropertyDescriptor(r,t);if(void 0===o){var i=Object.getPrototypeOf(r);return null===i?void 0:e(i,t,n)}if("value"in o)return o.value;var a=o.get;if(void 0!==a)return a.call(n)},r.inherits=function(e,r){if("function"!=typeof r&&null!==r)throw new TypeError("Super expression must either be null or a function, not "+typeof r);e.prototype=Object.create(r&&r.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),r&&(Object.setPrototypeOf?Object.setPrototypeOf(e,r):e.__proto__=r)},r.instanceof=function(e,r){return null!=r&&"undefined"!=typeof Symbol&&r[Symbol.hasInstance]?r[Symbol.hasInstance](e):e instanceof r},r.newArrowCheck=function(e,r){if(e!==r)throw new TypeError("Cannot instantiate an arrow function")},r.objectDestructuringEmpty=function(e){if(null==e)throw new TypeError("Cannot destructure undefined")},r.objectWithoutProperties=function(e,r){var t={};for(var n in e)r.indexOf(n)>=0||Object.prototype.hasOwnProperty.call(e,n)&&(t[n]=e[n]);return t},r.possibleConstructorReturn=function(e,r){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!r||"object"!=typeof r&&"function"!=typeof r?e:r},r.set=function e(r,t,n,o){var i=Object.getOwnPropertyDescriptor(r,t);if(void 0===i){var a=Object.getPrototypeOf(r);null!==a&&e(a,t,n,o)}else if("value"in i&&i.writable)i.value=n;else{var u=i.set;void 0!==u&&u.call(o,n)}return n},r.slicedToArray=function(){function e(e,r){var t=[],n=!0,o=!1,i=void 0;try{for(var a,u=e[Symbol.iterator]();!(n=(a=u.next()).done)&&(t.push(a.value),!r||t.length!==r);n=!0);}catch(e){o=!0,i=e}finally{try{!n&&u.return&&u.return()}finally{if(o)throw i}}return t}return function(r,t){if(Array.isArray(r))return r;if(Symbol.iterator in Object(r))return e(r,t);throw new TypeError("Invalid attempt to destructure non-iterable instance")}}(),r.taggedTemplateLiteral=function(e,r){return Object.freeze(Object.defineProperties(e,{raw:{value:Object.freeze(r)}}))},r.temporalRef=function(e,r,t){if(e===t)throw new ReferenceError(r+" is not defined - temporal dead zone");return e},r.temporalUndefined={},r.toArray=function(e){return Array.isArray(e)?e:Array.from(e)},r.toConsumableArray=function(e){if(Array.isArray(e)){for(var r=0,t=Array(e.length);r<e.length;r++)t[r]=e[r];return t}return Array.from(e)}}("undefined"==typeof global?self:global);</script><script type="text/javascript" src="./webjars/webcomponentsjs/webcomponents-loader.js"></script><script type="text/javascript">//<![CDATA[
(function() {	var apps = {};	var widgetsets = {};					var log;	if (typeof console === undefined || !window.location.search.match(/[&?]debug(&|$)/)) {		/* If no console.log present, just use a no-op */		log = function() {};	} else if (typeof console.log === "function") {		/* If it's a function, use it with apply */		log = function() {		console.log.apply(console, arguments);		};	} else {		/* In IE, its a native function for which apply is not defined, but it works		 without a proper 'this' reference */		log = console.log;	}		var isWidgetsetLoaded = function(widgetset) {		var className = widgetset.replace(/\./g, "_");		return (typeof window[className]) != "undefined";	};	var loadWidgetset = function(url, widgetset) {		if (widgetsets[widgetset]) {			return;		}		log("load widgetset", url, widgetset);		setTimeout(function() {		if (!isWidgetsetLoaded(widgetset)) {				alert("Failed to load the widgetset: " + url);			}		}, 15000);			var scriptTag = document.createElement('script');		scriptTag.setAttribute('type', 'text/javascript');		scriptTag.setAttribute('src', url);		document.getElementsByTagName('head')[0].appendChild(scriptTag);		widgetsets[widgetset] = {			pendingApps: []		};	};		var isInitializedInDom = function(appId) {		var appDiv = document.getElementById(appId);		if (!appDiv) {			return false;		}		for ( var i = 0; i < appDiv.childElementCount; i++) {			var className = appDiv.childNodes[i].className;			/* If the app div contains a child with the class			"v-app-loading" we have only received the HTML			but not yet started the widget set			(UIConnector removes the v-app-loading div). */			if (className && className.indexOf("v-app-loading") != -1) {				return false;			}		}		return true;	};	/* 	 * Needed for Testbench compatibility, but prevents any Vaadin 7 app from	 * bootstrapping unless the legacy vaadinBootstrap.js file is loaded before	 * this script.	 */    window.Vaadin = window.Vaadin || {};	window.Vaadin.Flow = window.Vaadin.Flow || {        clients: {},		initApplication: function(appId, config) {			var testbenchId = appId.replace(/-\d+$/, '');		if (apps[appId]) {				if (window.Vaadin && window.Vaadin.Flow && window.Vaadin.Flow.clients && window.Vaadin.Flow.clients[testbenchId] && window.Vaadin.Flow.clients[testbenchId].initializing) {					throw "Application " + appId + " is already being initialized";				}				if (isInitializedInDom(appId)) {			throw "Application " + appId + " already initialized";				}			}				log("init application", appId, config);						window.Vaadin.Flow.clients[testbenchId] = {					isActive: function() {						return true;					},			initializing: true			};						var getConfig = function(name) {				var value = config[name];				return value;			};						/* Export public data */			var app = {				getConfig: getConfig			};		apps[appId] = app;						if (!window.name) {				window.name =  appId + '-' + Math.random();			}				var widgetset = "client";			widgetsets[widgetset] = {					pendingApps: []				};			if (widgetsets[widgetset].callback) {		log("Starting from bootstrap", appId);				widgetsets[widgetset].callback(appId);			}  else {				log("Setting pending startup", appId);			widgetsets[widgetset].pendingApps.push(appId);			}				return app;		},		getAppIds: function() {			var ids = [ ];			for (var id in apps) {				if (apps.hasOwnProperty(id)) {					ids.push(id);				}			}			return ids;	},		getApp: function(appId) {			return apps[appId];		},		registerWidgetset: function(widgetset, callback) {			log("Widgetset registered", widgetset);			var ws = widgetsets[widgetset];			if (ws && ws.pendingApps) {				ws.callback = callback;				for(var i = 0; i < ws.pendingApps.length; i++) {					var appId = ws.pendingApps[i];					log("Starting from register widgetset", appId);					callback(appId);				}				ws.pendingApps = null;			}		}	};		log('Flow bootstrap loaded');		if (typeof window.__gwtStatsEvent != 'function') {window.Vaadin.Flow.gwtStatsEvents = [];window.__gwtStatsEvent = function(event) {window.Vaadin.Flow.gwtStatsEvents.push(event); return true;};};		var uidl = {
    "syncId": 0,
    "clientId": 0,
    "changes": [
        {
            "node": 1,
            "type": "put",
            "key": "tag",
            "feat": 0,
            "value": "body"
        },
        {
            "node": 1,
            "type": "put",
            "key": "alwaysXhrToServer",
            "feat": 5,
            "value": true
        },
        {
            "node": 1,
            "type": "put",
            "key": "pushMode",
            "feat": 5,
            "value": "DISABLED"
        },
        {
            "node": 1,
            "type": "put",
            "key": "parameters",
            "feat": 5,
            "nodeValue": 2
        },
        {
            "node": 1,
            "type": "splice",
            "feat": 2,
            "index": 0,
            "addNodes": [
                4
            ]
        },
        {
            "node": 1,
            "type": "splice",
            "feat": 11,
            "index": 0,
            "add": [
                "v-generated-body"
            ]
        },
        {
            "node": 1,
            "type": "put",
            "key": "scroll",
            "feat": 3,
            "value": "auto"
        },
        {
            "node": 2,
            "type": "attach"
        },
        {
            "node": 2,
            "type": "put",
            "key": "fallbackTransport",
            "feat": 6,
            "value": "long-polling"
        },
        {
            "node": 2,
            "type": "put",
            "key": "transport",
            "feat": 6,
            "value": "websocket"
        },
        {
            "node": 3,
            "type": "attach"
        },
        {
            "node": 3,
            "type": "put",
            "key": "tag",
            "feat": 0,
            "value": "div"
        },
        {
            "node": 3,
            "type": "put",
            "key": "innerHTML",
            "feat": 1,
            "value": "\n\tCould not navigate to 'import'\n\t<p>Reason: Couldn't find route for 'import'</p>\n\t<p></p><div>Available routes:</div>\n\t<p></p>\n\t<ul>\n\t\t<li><a href=\"\">&lt;root&gt;</a></li>\n\t</ul>\n\t<p>This detailed message is only shown when running in development mode.</p>\n"
        },
        {
            "node": 4,
            "type": "attach"
        },
        {
            "node": 4,
            "type": "put",
            "key": "tag",
            "feat": 0,
            "value": "div"
        },
        {
            "node": 4,
            "type": "splice",
            "feat": 2,
            "index": 0,
            "addNodes": [
                3
            ]
        }
    ],
    "timings": [
        0,
        -1
    ],
    "Vaadin-Security-Key": "fcc02d1f-ecfa-4ad2-bce7-627eef4e42c2",
    "Vaadin-Push-ID": "40285c31-f59c-4197-98f6-93329bc474f8"
};	var config = {
    "frontendUrlEs6": "context://frontend/",
    "frontendUrlEs5": "context://frontend/",
    "versionInfo": {
        "vaadinVersion": "1.0.0.beta2",
        "atmosphereVersion": "2.4.5.vaadin2"
    },
    "comErrMsg": {
        "caption": "Communication problem",
        "message": "Take note of any unsaved data, and <u>click here</u> or press ESC to continue.",
        "url": null
    },
    "authErrMsg": {
        "caption": "Authentication problem",
        "message": "Take note of any unsaved data, and <u>click here</u> or press ESC to continue.",
        "url": null
    },
    "sessExpMsg": {
        "caption": "Session Expired",
        "message": "Take note of any unsaved data, and <u>click here</u> or press ESC key to continue.",
        "url": null
    },
    "contextRootUrl": "./",
    "debug": true,
    "heartbeatInterval": 300,
    "v-uiId": 0
};	config.uidl = uidl;    window.Vaadin.Flow.initApplication("ROOT-2521314", config);})();//]]></script><script type="text/javascript" defer src="./VAADIN/static/client/client-63F60563F27F9CAB0329071E83FEC419.cache.js"></script></head><body><noscript>You have to enable javascript in your browser to use this web site.</noscript></body></html>

```


Also,  if you post a large file, you get thre following response:

```bash


http -f POST :8080/import file@~/WPC/full/OSM.mbtiles.gz

http: error: ConnectionError: ('Connection aborted.', BrokenPipeError(32, 'Broken pipe')) while doing POST request to URL: http://localhost:8080/import
```