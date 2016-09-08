//Project Obtain from Interviewer.

Imagine we're writing some code for a magazine editor who would like some help analyzing writing samples.
She would like a simple program that takes a paragraph as input, and returns all of the unique words in that paragraph,
along with the number of times each of those words occurred.

More explicitly:
Given some text p, write a method f such that f(p) returns [['word', word_count], ['word2', word2_count]],
where word_count is the number of times 'word' appears in p and word2_count is the number of times 'word2’ appears in p.
    For Example:
      p = "Hello World!"
      f(p) == [['hello', 1], ['world', 1]]

      p = "To be, or not to be."
      f(p) == [['to', 2], ['be', 2], ['or', 1], ['not', 1]]


