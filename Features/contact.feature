Feature: Contact Form

  Scenario Outline: To test Valid registration
    When Verify myContactForm Page is open
    Then Enter Your Name "<Uname>"
    Then Enter valid email address "<Email>"
    Then Enter message in the Message Textbox "<msg>"
    Then submit form

    Examples: 
      | Uname | Email           | msg       |
      | sunil | sunil@gmail.com | hello all |
