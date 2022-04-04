Let's build out the application that we started to build in the previous article.

## Getting Started

```no-highlight
et get java-launch-library
cd java-launch-library
idea .
```

## Core User Stories

### Provide Main Menu

```no-highlight
As a Launcher
I want to interact with the Launch Library
So that I can further my learning
```

Acceptance Criteria:

- I'm presented with options to contribute a book, check out a book, return a book, or quit
- If I make an invalid selection, I should be prompted to make a valid selection

Implementation Details:

- Just create the menu in this user story - you'll implement these options in subsequent features.

### Quit Program

```no-highlight
As a Launcher
I want to quit the program
So that I can get back to my studies
```

Acceptance Criteria:

- When I'm presented with the main menu, I have an option to quit
- When I select that option, the program terminates

### Add a Book

```no-highlight
As a selfless Launcher
I want to donate a book to the library
So that others can benefit from its wisdom
```

Acceptance Criteria:

- When I'm presented with the main menu, I have an option to donate a book
- If I select that option, I'm prompted to enter the title of the book
- If I do not enter a title, I'm returned to the main menu
- If I enter a title, the title is saved among the list of other books in the library

### Check out a Book

```no-highlight
As a voracious learning Launcher
I want to borrow a book
So that I can learn more
```

Acceptance Criteria:

- When I'm presented with the main menu, I have an option to check out a book
- If I select that option, I'm presented with the list of books currently in the library.
- I can choose a book by typing in the index of the book as part of the listing
- If I don't enter anything, I'm brought back to the main menu
- If I don't specify a valid index, I'm asked to make a valid selection
- When I specify a valid index, the book is removed from the library and added to my list of checked out books. I am then returned to the main menu

### Return a Book

```no-highlight
As a learned Launcher
I want to return a book I finished
So that others can benefit from its wisdom
```

Acceptance Criteria:

- When I'm presented with the main menu, I have an option to return a book
- If I haven't yet checked out any books, I'm alerted to that fact and brought back to the main menu
- If I have checked out books, the titles are listed along with a correlating index
- If I don't enter anything, I'm brought back to the main menu
- If I don't specify a valid index, I'm asked to make a valid selection
- When I specify a valid index, the book is removed from my list of checked out books, and added back to the library. I am then returned to the main menu

## Non-Core User Stories

### Return All Books Option

```no-highlight
As a learned Launcher
I want to return all of my checked out books
So that I don't have to return each one individually
```

Acceptance Criteria:

- When I'm returning books, I have an option to return all of my checked out books
- When I select that option, my list of checked out books is emptied, and all of the books are added back to the library

### Limit Checkouts to a Default 2 Book Maximum

```no-highlight
As an Experience Engineer
I want to limit checked out books to 2 per person
So that all Launchers can benefit from the library
```

Acceptance Criteria:

- If I have already checked out 2 books, I'm prohibited from checking out a third

### Increase Authorized Checkouts for Every 2 Books You Contribute

```no-highlight
As an Experience Engineer
I want to reward those that contribute to the library
So that Launchers are encouraged to donate books
```

Acceptance Criteria:

- For every 2 books I donate to the library, I'm awarded the ability to check out an additional book

### Save Checked Out Books to Disk

```no-highlight
As a Library Administrator
I want lent out books to be persisted
So that the system can recover
```

Acceptance Criteria:

- If I have booked that I've checked out, and I quit the program, when I re-run the program, it remembers that I had checked out books.

Implementation Details:

- Create a file called checkedOutBooks.json
- When a user checks out a `book` it is added to the JSON
- When a user selects the option to return a book the list of books they can return is provided from the JSON
- When a book is returned it should be removed from the JSON
- Don't worry about multiple users here
