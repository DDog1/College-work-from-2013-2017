function showWrongAnswer(){
    document.id('error').set('html', 'Wrong answer, Please try again');
}

function showScore() {
    var score = quizMaker.getScore();

    var el = new Element('h3');
    el.set('html', 'Your Results: ');

    document.id('result').adopt(el);

   var e2 = new Element('h4');
    e2.set('html', 'Score: ' + score.numCorrectAnswers + ' of ' + score.numQuestions);

    document.id('result').adopt(e2);

    if(score.numCorrectAnswers == 10){
        document.cookie = "ReBootNetworking=2; path=/";
       var e3 = new Element('h4');
        e3.set('html', 'Good Work! <img src="/../images/win.png">');

        document.id('result').adopt(e3);
    }
    else{
        document.cookie = "ReBootNetworking=1; path=/";
    }


    if(score.incorrectAnswers.length > 0) {
        el.set('html', 'Give it another go!<img src="/../images/loss.png"><br>Incorrect answers:');
        document.id('result').adopt(el);

        for(var i=0;i<score.incorrectAnswers.length;i++) {
            var incorrectAnswer = score.incorrectAnswers[i];
            el = new Element('div');
            el.set('html', '<b>' + incorrectAnswer.label + '</b>');
            document.id('result').adopt(el);

            el = new Element('div');
            el.set('html', '<div class="wrongUserInput">' + incorrectAnswer.userAnswer);
            document.id('result').adopt(el);
            e1 = new Element('br');
        }

        e1.set('html', 'To move on you need to answer ', score.incorrectAnswers, ' correctly');
    }
    var e4 = new Element('h4');
    e4.set('html', '<a href="../../quiz.php">Back to Quiz...</a>');
    document.id('result').adopt(e4);
}

var questions = [
    {
        label : 'A _____ is a device that forwards packets between networks by processing the routing information included in the packet?',
        options : ['Bridge', 'Router', 'Firewall', 'All of the mentioned'],
        answer : ['Router'],
        forceAnswer : true
    },
    {
        label : 'Network congestion occurs_____ ',
        options : ['When a system terminates', 'When connection between two nodes terminates', 'None of the mentioned', 'In case of traffic overloading'],
        answer : ['In case of traffic overloading'],
        forceAnswer : true
    },
    {
        label : 'Communication channel is shared by all the machines on the network in ',
        options : ['Broadcast network','Unicast network', 'Multicast network', 'None of the mentioned'],
        answer : ['Broadcast network'],
        forceAnswer : true
    },
    {
        label : 'What are the layers of the OSI Model? ',
        options : ['Application, Presentation, Transport, Session, Physical, Network.','Presentation, Network, Datalink, Transport, Session.','Physical, Network, Link-State, Transport, Session, Presentation, Application.','Application, Presentation, Session, Transport, Network, Datalink, Physical' ],
        answer : ['Application, Presentation, Session, Transport, Network, Datalink, Physical'],
        forceAnswer : true
    },
    {
        label : 'Which statement is true regarding the user exec and privileged exec mode?',
        options : ['They both require the enable password ','The ? only wo rks in Privileged exec', 'User exec is a subset of the privileged exec','They are identical' ],
        answer : ['User exec is a subset of the privileged exec'],
        forceAnswer : true
    },
    {
        label: 'Bluetooth is an example of',
        options : ['Local area network','Virtual private network','None of the mentioned', 'Personal area network'],
        answer :['Personal area network'],
        forceAnswer : true
    },
    {
        label: 'Two devices are in network if____ ',
        options : ['A process is running on both devices', 'A process in one device is able to exchange information with a process in another device', 'PIDs of the processes running of different devices are same','None of the mentioned'],
        answer :['A process in one device is able to exchange information with a process in another device'],
        forceAnswer : true
    },
    {
        label: 'Which one of the following computer network is built on the top of another network?',
        options : ['Prior network','Chief network','Overlay network', 'Prime network'],
        answer :['Overlay network'],
        forceAnswer : true
    },
    {
        label: 'A list of protocols used by a system, one protocol per layer, is called',
        options : ['Protocol architecture','Protocol suit','None of the mentioned', 'Protocol stack'],
        answer :['Protocol stack'],
        forceAnswer : true

    },
    {
        label: 'In computer network nodes are',
        options : ['All of the mentioned', 'The computer that originates the data','The computer that routes the data','The computer that terminates the data'],
        answer :['All of the mentioned'],
        forceAnswer : true
    }
]

function showAnswerAlert() {
    alert("You have to answer before you continue to the next question");
}

function clearErrorBox() {
    document.id('error').set('html','');
}
var quizMaker = new DG.QuizMaker({

    questions : questions,
    el : 'questions',
    forceCorrectAnswer:false,
    listeners : {
        'finish' : showScore,
        'missinganswer' : showAnswerAlert,
        'sendanswer' : clearErrorBox,
        'wrongAnswer' : showWrongAnswer
    }
});
quizMaker.start();