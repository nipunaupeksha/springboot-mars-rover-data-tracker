let marsApiButtons = document.querySelectorAll("button[id*='marsApi']");
marsApiButtons.forEach(button=>button.addEventListener('click',function(){
    const buttonId = this.id;
    const roverId = buttonId.split('marsApi')[1];
    const apiData = document.getElementById('marsApiRoverData');
    apiData.value = roverId;
    document.getElementById('frmRoverType').submit();
}));

function getUrlParameter(name){
    name = name.replace(/[\[]/,'\\[').replace(/[\]]/,'\\]');
    var regex = new RegExp('[\\?&]'+name+'=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '':decodeURIComponent(results[1].replace(/\+/g,' '));
};

function highlightBtnRoverType(roverType){
    if (roverType == ''){
        roverType = 'Opportunity';
    }
    document.getElementById('marsApi'+roverType).classList.remove('btn-secondary');
    document.getElementById('marsApi'+roverType).classList.add('btn-primary');
};

let marsRoverType = getUrlParameter('marsApiRoverData');
let marsSol = getUrlParameter('marsSol');
if(marsSol==''){
    marsSol = 1;
}
document.getElementById("marsSol").value=marsSol;
highlightBtnRoverType(marsRoverType);

