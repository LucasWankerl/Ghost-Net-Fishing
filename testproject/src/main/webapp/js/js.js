function toggleNavbar(){ 
    var navi = document.getElementById("myNav");
    var icon = document.getElementById("myMenuIcon");
    if (navi.className === "navbar") {
      navi.className += " open";
      icon.src ="images/Kreuz.png";
    } else {
      navi.className = "navbar";
      icon.src="images/icon.png";
    }
  }
