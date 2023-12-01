// Generate a random number between 1 and 10
const secretNumber = Math.floor(Math.random() * 10) + 1;

// Initialize variables
let attempts = 0;

// Get elements
const slider = document.getElementById('guess-slider');
const output = document.getElementById('output');
const circles = document.getElementById('circles');

// Function to update the output
function updateOutput() {
    const guess = parseInt(slider.value);
    attempts++;

    if (guess < secretNumber) {
        output.textContent = `Attempt ${attempts}: Too low!`;
        output.style.color = 'yellow';
        circles.children[guess - 1].style.backgroundColor = 'yellow';
    } else if (guess > secretNumber) {
        output.textContent = `Attempt ${attempts}: Too high!`;
        output.style.color = 'red';
        circles.children[guess - 1].style.backgroundColor = 'red';
    } else {
        output.textContent = `Congratulations! You guessed it in ${attempts} attempts.`;
        output.style.color = 'green';
        circles.children[guess - 1].style.backgroundColor = 'green';
        slider.disabled = true;
    }

    if (attempts >= 3 && guess !== secretNumber) {
        output.textContent = `Game over! The correct number was ${secretNumber}.`;
        output.style.color = 'red';
        slider.disabled = true;
    }
}

// Event listener for slider input
slider.addEventListener('input', updateOutput);

// Create circles representing numbers 1 to 10
for (let i = 1; i <= 10; i++) {
    const circle = document.createElement('div');
    circle.className = 'circle';
    circle.textContent = i;
    circle.addEventListener('click', () => {
        slider.value = i;
        updateOutput();
    });
    circles.appendChild(circle);
}
