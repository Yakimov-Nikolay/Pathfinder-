var trackPath = 'track1.gpx';

var mymap = L.map(document.getElementById('map'));

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    maxZoom: 50
}).addTo(mymap);

function drawTrack(track) {
    let coordinates = track.points.map(p => [p.lat.toFixed(5), p.lon.toFixed(5)]);

    var polyline = L.polyline(coordinates, { weight: 6, color: 'darkred' }).addTo(mymap);

    // zoom the map to the polyline
    mymap.fitBounds(polyline.getBounds());
}

fetch(trackPath)
    .then(function (response) {
        return response.text();
    }).then(function (gpxData) {
    let gpx = new gpxParser();
    gpx.parse(gpxData);

    document.getElementById("track-name").innerText = gpx.tracks[0].name;

    document.getElementById("totalDistance").innerText = (gpx.tracks[0].distance.total / 1000).toFixed(3);

    document.getElementById("gpxDownload").innerText = trackPath;
    document.getElementById("gpxDownload").setAttribute("href", trackPath);

    drawTrack(gpx.tracks[0]);
});