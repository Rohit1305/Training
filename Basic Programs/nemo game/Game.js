document.addEventListener("DOMContentLoaded", function () {
    const circles = [];
    let nemoIndex;
    let chances = 5;

    // Create 9 circles and add them to the game container
    for (let i = 0; i < 10; i++) {
        const circle = document.createElement("div");
        circle.className = "circle";
        circle.textContent = i + 1;
        circle.addEventListener("click", () => checkCircle(i));
        document.getElementById("gameContainer").appendChild(circle);
        circles.push(circle);
    }

    // Place Nemo under one of the circles
    nemoIndex = Math.floor(Math.random() * 10);

    function checkCircle(index) {
        let nemoFound = false;
        if (index === nemoIndex) {
            document.getElementById("result").textContent = "Congratulations! You found Nemo!";
            replaceCircleWithNemo(index);
            disableAllCircles();
            setTimeout(function () {
                window.location.reload();
            }, 2000);
        } else {
            chances--;
            if (chances === 0) {
                document.getElementById("result").textContent = "Sorry you lose! Nemo was under circle " + (nemoIndex + 1);
                disableAllCircles();
                setTimeout(function () {
                    window.location.reload();
                }, 2000);
            } 
            else {
                document.getElementById("result").textContent = "Try again. Chances left: " + chances;
                replaceCircleWithCross(index);
                circles[index].removeEventListener("click", () => checkCircle(index));
            }
        }
    }

    function replaceCircleWithNemo(index) {
        const nemoImage = document.createElement("img");
        nemoImage.src = "nemo.png"; // Replace with the correct path to your Nemo image
        nemoImage.alt = "Nemo";

        const circle = circles[index];
        circle.textContent = ''; // Clear circle text
        circle.style.backgroundColor = 'transparent'; // Make the background transparent
        circle.style.border = 'none'; // Remove the border

        // Replace the circle with the Nemo image
        circle.appendChild(nemoImage);
    }

    function replaceCircleWithCross(index) {
        const crossImage = document.createElement("img");
        crossImage.src = "cross.png"; // Replace with the correct path to your cross image
        crossImage.alt = "Cross";

        const circle = circles[index];
        circle.textContent = ''; // Clear circle text
        circle.style.backgroundColor = 'transparent'; // Make the background transparent
        circle.style.border = 'none'; // Remove the border

        // Replace the circle with the cross image
        circle.appendChild(crossImage);
    }

    function disableAllCircles() {
        for (const circle of circles) {
            circle.removeEventListener("click", checkCircle);
        }
    }
});
