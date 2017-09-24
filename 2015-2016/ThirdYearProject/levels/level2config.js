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
        document.cookie = "ReBootNetworking=3; path=/";
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
        label : 'ATM uses the___',
        options : ['Asynchronous time division multiplexing', 'Asynchronous frequency division multiplexing', 'Asynchronous space division multiplexing', 'None of the mentioned'],
        answer : ['Asynchronous time division multiplexing'],
        forceAnswer : true
    },
    {
        label : 'ATM and frame relay are_____ ',
        options : ['Datagram networks', 'Virtual circuit networks',  'Both ', 'None of the mentioned'],
        answer : ['Virtual circuit networks'],
        forceAnswer : true
    },
    {
        label : 'Frame relay has error detection at the',
        options : ['Physical layer', 'Network layer', 'Data link layer','Transport layer'],
        answer : ['Data link layer'],
        forceAnswer : true
    },
    {
        label : 'What is FRAD in frame relay network? ',
        options : ['FRAD assembles and disassembles the frames coming from other protocols','FRAD is used for modulation and demodulation','FRAD is used for error detection','none of the mentioned' ],
        answer : ['FRAD assembles and disassembles the frames coming from other protocols'],
        forceAnswer : true
    },
    {
        label : 'Physical or logical arrangement of network is ______',
        options : ['Routing', 'Networking','None of the mentioned','Topology'],
        answer : ['Topology'],
        forceAnswer : true
    },
    {
        label: 'This topology requires multipoint connection',
        options : ['Star','Bus','Mesh', 'Ring'],
        answer :['Bus'],
        forceAnswer : true
    },
    {
        label: 'Data communication system within a building or campus is _____',
        options : ['WAN', 'MAN', 'LAN', 'None of the mentioned'],
        answer :['LAN'],
        forceAnswer : true
    },
    {
        label: 'Most packet switches use this principle',
        options : ['Store and forward','Stop and wait','Both of the mentioned', 'None of the mentioned'],
        answer :['Store and forward'],
        forceAnswer : true
    },
    {
        label: 'In _________ resources are allocated on demand.',
        options : ['Circuit switching', 'Packet switching','Line switching', 'Frequency switching'],
        answer :['Packet switching'],
        forceAnswer : true

    },
    {
        label: 'Which of the following delay is faced by the packet in travelling from one end system to another ?',
        options : ['All of the mentioned', 'Transmission delay','Queuing delay','Propagation delay'],
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