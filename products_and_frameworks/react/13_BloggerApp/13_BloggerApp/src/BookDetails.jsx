function BookDetails({ available }) {
  if (available) {
    return <p>Book: "Atomic Habits" is available in the library.</p>;
  }
  return <p>Book: "Atomic Habits" is currently unavailable.</p>;
}

export default BookDetails;
