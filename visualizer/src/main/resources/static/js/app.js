var stompClient = null;


function connect() {
    var socket = new SockJS('/com-s63d-d');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
       console.log('Connected: ' + frame);
        stompClient.subscribe('/location', function (coord) {
            showCoord(JSON.parse(coord.body))
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}


function showCoord(coord) {
    if (marker != null) {
        map.removeLayer(marker)
    }
    marker = L.marker(coord).addTo(map);
}

var map;
var marker;
$(function () {
    map = L.map('mapid').setView([47.516231, 14.550072], 8);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox.streets',
        accessToken: 'pk.eyJ1IjoibXVyZnp3IiwiYSI6ImNqZHluaDUyMDFkcDQycXM0cHRuc2VsbWgifQ.j8GNzXpH9zA-eAMa36h9cg'
    }).addTo(map);
   connect()
});