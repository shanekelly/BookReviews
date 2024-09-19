function getBook(id) { // Function to fetch book and review data based on the given ID.
    fetch("/books/" + id) // Fetching book data from the server.
            .then(data => data.json()) // Parsing the response as JSON.
            .then(function (data) { // Handling the book data.
                showBook(data); // Calling the showBook function to display book details.
            });

    fetch("/reviews/" + id) // Fetching review data from the server.
            .then(data => data.json()) // Parsing the response as JSON.
            .then(function (data) { // Handling the review data.
                showReviews(data); // Calling the showReviews function to display reviews.
            });
}

function showBook(bookdata) { // Function to display book details.
    var bookdetails =
            "<br/>Title: " + bookdata.title + // Constructing book details HTML.
            "<br/>Authors: " + bookdata.authors;
    document.getElementById("bookdetails").innerHTML = bookdetails; // Displaying book details in the HTML element with id "bookdetails".
}

function showReviews(reviewdata) { // Function to display reviews.
    var reviews = ""; // Initializing a string to hold the reviews HTML.
    for (var i = 0; i < reviewdata.length; i++) { // Looping through each review data.
        reviews += "<ul><li>" + reviewdata[i].review + "</li></ul>"; // Constructing review list items.
    }
    document.getElementById("reviews").innerHTML = reviews; // Displaying reviews in the HTML element with id "reviews".
}
