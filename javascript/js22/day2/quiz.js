const questions = [
    {
      id: 1,
      question: "What is the capital of France?",
      options: ["Berlin", "London", "Paris", "Madrid"],
      correctAnswer: 2,
      userAnswer: null
    },
    {
      id: 2,
      question: "Which planet is known as the Red Planet?",
      options: ["Venus", "Mars", "Jupiter", "Saturn"],
      correctAnswer: 1,
      userAnswer: null
    },
    {
      id: 3,
      question: "What is the largest mammal?",
      options: ["Blue Whale", "Elephant", "Giraffe", "Hippopotamus"],
      correctAnswer: 0,
      userAnswer: null
    }
  ];
  
  let currentQuestionIndex = 0;
  const questionElement = document.querySelector('#question');
  const optionsElement = document.querySelector('#options');
  const nextButton = document.querySelector('#next-button');
  const resultList = document.querySelector('#result-list');
  const resultsContainer = document.querySelector('#results');
  
  function showQuestion(index) {
    const question = questions[index];
    questionElement.textContent = question.question;
    optionsElement.innerHTML = '';
  
    question.options.forEach((option, i) => {
      const optionButton = document.createElement('button');
      optionButton.textContent = option;
      optionButton.addEventListener('click', () => selectAnswer(i));
      optionsElement.appendChild(optionButton);
    });
  }
  
  function selectAnswer(index) {
    const optionButtons = optionsElement.querySelectorAll('button');
    optionButtons.forEach((button, i) => {
      if (i === index) {
        button.classList.add('selected');
      } else {
        button.classList.remove('selected');
      }
    });
  
    questions[currentQuestionIndex].userAnswer = index;
  }
  
  function showResults() {
    resultsContainer.style.display = 'block';
    resultList.innerHTML = '';
  
    questions.forEach(question => {
      const resultItem = document.createElement('li');
      const isCorrect = question.userAnswer === question.correctAnswer;
      const correctOption = question.options[question.correctAnswer];
      const userSelectedOption = question.options[question.userAnswer];
      
      resultItem.textContent = `${question.question} - ${
        isCorrect ? 'Correct' : 'Incorrect'
      }. Correct answer: ${correctOption}. You selected: ${userSelectedOption}`;
      
      resultList.appendChild(resultItem);
    });
  }
  
  nextButton.addEventListener('click', () => {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
      showQuestion(currentQuestionIndex);
    } else {
      showResults();
    }
  });
  
  
  showQuestion(currentQuestionIndex);
  