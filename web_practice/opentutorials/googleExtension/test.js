// const BodyText = myBody.innerText;
chrome.storage.sync.get(function(data){
    // alert(data[0]);
    document.querySelector('#userText').value = data.userWords;
});

document.querySelector('#userText').addEventListener('change', function (){

    const userText = document.querySelector('#userText').value;
    // alert(userText.value);

    chrome.storage.sync.set({
        userWords:userText
    });

    chrome.tabs.executeScript({
        code: 'document.querySelector("body").innerText;'
    }, function(result){
    
        const bodyText = result[0];
        const bodyNum = bodyText.split(' ').length;

        const myNum = bodyText.match(new RegExp('\\b' + userText + '\\b', 'gi')).length;

        // const myNum = bodyText.match(new RegExp('\\b(the|this|was)\\b', 'gi')).length;
    
    
        // alert(bodyNum / myNum);
        const rate = document.querySelector('#result');
        let fixedRate = (myNum / bodyNum * 100);
        fixedRate = fixedRate.toFixed(1);
        rate.innerText = fixedRate + "%";
    });
});

