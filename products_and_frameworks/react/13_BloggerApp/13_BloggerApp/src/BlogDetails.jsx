function BlogDetails({ published }) {
  return (
    <p>
      {published
        ? 'Blog: "React Hooks Explained" has been published.'
        : 'Blog: "React Hooks Explained" is still in draft.'}
    </p>
  );
}

export default BlogDetails;
