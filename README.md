# Playwright_AI_Powered - Complete Learning & Automation Framework

Comprehensive project combining AI/ML foundations with enterprise-level Selenium automation testing for Salesforce.

## Project Overview

Playwright_AI_Powered is a two-chapter project that bridges theoretical AI/ML knowledge with practical automation testing. It provides foundational understanding of AI concepts and implements production-ready automation frameworks.

## Project Structure

```
Playwright_AI_Powered/
├── chapter_01_foundations/          # AI/ML/DL Fundamentals
│   ├── ch_01_ml_ai_deep_learning.md
│   ├── ch_01_llm_comparisons.md
│   ├── ch_01_anti_hallucination_rule.md
│   └── practical_guides/
│       └── ch_01_local_llm_setup_ollama.md
├── chapter_02_prompts/              # Prompt Engineering & Automation
│   ├── Prompt_Frameworks.md
│   ├── RICEPOT.md
│   ├── anti_hallucinations_rules.md
│   └── SeleniumFramework/           # Selenium Automation Framework
│       ├── pom.xml
│       ├── src/
│       │   ├── main/java/pages/
│       │   │   └── LoginPage.java
│       │   └── test/java/
│       │       ├── base/BaseTest.java
│       │       ├── tests/
│       │       │   ├── LoginValidTest.java
│       │       │   └── LoginInvalidTest.java
│       │       └── resources/testng.xml
│       └── README.md
└── README.md (this file)
```

---

## Chapter 01: Foundations

### Overview
Foundational knowledge in Machine Learning, Artificial Intelligence, and Deep Learning with practical setup instructions for local LLM deployment.

### Files

| File | Description |
|------|-------------|
| **ch_01_ml_ai_deep_learning.md** | Core concepts: ML principles, AI fundamentals, DL architectures, and relationships between ML/AI/DL |
| **ch_01_llm_comparisons.md** | Comprehensive comparison of Large Language Models, architectures, capabilities, and use cases |
| **ch_01_anti_hallucination_rule.md** | Strategies and techniques to prevent AI model hallucinations |
| **practical_guides/ch_01_local_llm_setup_ollama.md** | Step-by-step guide to set up and run LLMs locally using Ollama |

### Key Topics

- **Machine Learning**: Algorithms, training methodologies, model evaluation
- **Artificial Intelligence**: Applications, ethics, real-world implementations
- **Deep Learning**: Neural networks, architectures, optimization techniques
- **LLM Comparison**: Feature analysis, performance benchmarks, selection criteria
- **Hallucination Prevention**: Validation techniques, reliability assurance
- **Local LLM Setup**: Ollama configuration, model management, inference optimization

### Learning Path

1. **Start**: ch_01_ml_ai_deep_learning.md - Build foundational knowledge
2. **Explore**: ch_01_llm_comparisons.md - Understand LLM landscape
3. **Learn**: ch_01_anti_hallucination_rule.md - Ensure reliability
4. **Practice**: practical_guides/ch_01_local_llm_setup_ollama.md - Hands-on setup

### Prerequisites

- Basic programming knowledge
- Familiarity with command line/terminal
- System resources (8GB+ RAM recommended for local LLMs)

---

## Chapter 02: Prompts & Automation

### Overview
Advanced prompt engineering techniques and enterprise-level Selenium automation framework for Salesforce login testing.

### Part A: Prompt Engineering

#### Files

| File | Description |
|------|-------------|
| **Prompt_Frameworks.md** | Comprehensive frameworks for effective prompt design and optimization |
| **RICEPOT.md** | RICEPOT methodology: Role, Instructions, Context, Examples, Persona, Output, Tone |
| **anti_hallucinations_rules.md** | Advanced techniques to prevent LLM hallucinations in production |

#### Key Topics

- **Prompt Frameworks**: Design patterns, structuring effective prompts, optimization strategies
- **RICEPOT Framework**: Structured approach to crafting precise prompts
  - **Role**: Define assistant perspective
  - **Instructions**: Specify exact requirements
  - **Context**: Provide background information
  - **Examples**: Show desired output format
  - **Persona**: Customize interaction style
  - **Output**: Define response structure
  - **Tone**: Set communication style
- **Hallucination Prevention**: Verification methods, fact-checking, validation patterns

### Part B: Selenium Automation Framework

#### Overview
Enterprise-grade Selenium automation framework for testing Salesforce login with Page Object Model, TestNG, and Maven.

#### Technology Stack

| Technology | Version |
|-----------|---------|
| Selenium WebDriver | 4.15.0 |
| TestNG | 7.8.1 |
| Maven | 3.11.0 |
| WebDriverManager | 5.6.3 |
| Java | 11+ |

#### Framework Structure

**Page Object Model**
- `LoginPage.java` - Complete page object with PageFactory
- XPath-based selectors (no CSS/ID)
- Reusable action methods
- Comprehensive exception handling

**Test Classes**
- `LoginValidTest.java` - 6 test cases for valid login scenarios
- `LoginInvalidTest.java` - 10 test cases for invalid login scenarios

**Configuration**
- `BaseTest.java` - Setup/teardown with TestNG lifecycle
- `pom.xml` - Maven dependencies and build configuration
- `testng.xml` - Test suite execution configuration

#### Test Coverage

**LoginValidTest (6 cases)**
1. Login page UI elements verification
2. Successful login with valid credentials
3. Login with remember me functionality
4. Remember me checkbox functionality
5. Username field input validation
6. Password field input validation

**LoginInvalidTest (10 cases)**
1. Invalid username login attempt
2. Invalid password login attempt
3. Both credentials invalid
4. Empty username validation
5. Empty password validation
6. Both credentials empty
7. Special characters in username
8. SQL injection attempt detection
9. Whitespace-only username
10. Very long password handling

#### Framework Features

✓ Page Object Model with PageFactory  
✓ XPath-only locators (no CSS/ID/name selectors)  
✓ WebDriverWait for explicit synchronization  
✓ Robust exception handling with try-catch blocks  
✓ TestNG annotations (@Test, @BeforeTest, @AfterTest, @BeforeSuite, @AfterSuite)  
✓ WebDriverManager for automatic driver management  
✓ Implicit and explicit wait strategies  
✓ No Thread.sleep() usage  
✓ Enterprise-grade code standards  
✓ Zero comments in production code  
✓ 16 comprehensive test cases  
✓ CI/CD ready configuration  

#### Quick Start

**Prerequisites**
- Java 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser

**Installation**
```bash
cd chapter_02_prompts/SeleniumFramework
mvn clean install
```

**Run All Tests**
```bash
mvn test
```

**Run Specific Test Class**
```bash
mvn test -Dtest=LoginValidTest
mvn test -Dtest=LoginInvalidTest
```

**Run with TestNG Configuration**
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

#### Code Example

**Page Object Model**
```java
public class LoginPage {
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void performLogin(String username, String password) throws Exception {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
```

**Test Implementation**
```java
public class LoginValidTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeTest
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Verify successful login with valid credentials")
    public void testValidLogin() throws Exception {
        loginPage.navigateToLoginPage();
        loginPage.performLogin("test@example.com", "Password123");
        Assert.assertNotEquals(driver.getCurrentUrl(), 
            "https://login.salesforce.com/?locale=in");
    }
}
```

---

## Chapter Learning Sequence

### Recommended Path

1. **Week 1: Foundations**
   - Complete Chapter 01: ML/AI/DL concepts
   - Study LLM comparisons
   - Learn hallucination prevention
   - Set up local Ollama environment

2. **Week 2: Prompt Engineering**
   - Study prompt frameworks
   - Master RICEPOT methodology
   - Review anti-hallucination techniques
   - Practice prompt optimization

3. **Week 3-4: Selenium Automation**
   - Understand Page Object Model
   - Study test implementation
   - Set up automation framework
   - Write and execute tests

---

## Best Practices Implemented

### Chapter 01
- Comprehensive theoretical foundation
- Practical hands-on guides
- Real-world application examples
- Structured learning path

### Chapter 02

**Prompt Engineering**
- Structured frameworks for prompt design
- RICEPOT methodology for consistency
- Hallucination prevention techniques
- Production-ready patterns

**Automation Framework**
- Page Object Model with PageFactory
- XPath-only selectors for robustness
- WebDriverWait for reliable synchronization
- Explicit exception handling
- TestNG lifecycle management
- Maven build automation
- No anti-patterns (no Thread.sleep, no CSS selectors)
- Enterprise-grade code standards
- Clean architecture and modularity
- Comprehensive test coverage
- CI/CD ready configuration

---

## Target Audience

- **AI/ML Learners**: Understanding ML, AI, and DL concepts
- **LLM Practitioners**: Deploying and optimizing language models
- **Prompt Engineers**: Crafting effective prompts with RICEPOT
- **QA Automation Testers**: Implementing enterprise automation frameworks
- **Salesforce Users**: Testing CRM login functionality
- **Development Teams**: Building reliable automation with best practices

---

## Key Takeaways

**Chapter 01**
- Solid foundation in ML/AI/DL principles
- Understanding of LLM capabilities and limitations
- Knowledge of hallucination prevention
- Practical skills for local LLM deployment

**Chapter 02**
- Advanced prompt engineering techniques
- Enterprise Selenium framework patterns
- Production-ready automation code
- Salesforce login testing expertise
- TestNG and Maven proficiency

---

## Getting Help

### Chapter 01 Resources
- Review markdown files for detailed explanations
- Follow step-by-step practical guides
- Experiment with local Ollama setup

### Chapter 02 Resources
- Study prompt framework examples
- Review Selenium test implementations
- Refer to code examples in test files
- Check TestNG configuration in testng.xml

---

## Contributing & Customization

### Extend Automation Framework
1. Add new page objects to `src/main/java/pages/`
2. Create test classes extending `BaseTest`
3. Update `testng.xml` with new test classes
4. Run `mvn test` to validate

### Customize Test Data
- Modify credentials in test methods
- Add parameterized tests with TestNG
- Create external data sources for test cases

---

## Project Status

✅ Chapter 01: Complete  
✅ Chapter 02: Complete  
✅ Selenium Framework: Production-Ready  
✅ Documentation: Comprehensive  

---

## Version Information

- **Project Version**: 1.0.0
- **Last Updated**: February 2026
- **Java Version**: 11+
- **Maven Version**: 3.6+

---

## Author

- **Name**: Meeti Jha
- **Role**: QA Automation Engineer
- **Expertise**: Selenium, Java, TestNG, Maven, CRM Automation, Salesforce Testing

---

## License & Usage

This project is designed for educational and professional learning purposes. Use as reference material and customize for specific organizational needs.

---

**Start Your Journey**: Begin with [chapter_01_foundations](chapter_01_foundations/) or jump to [chapter_02_prompts](chapter_02_prompts/) based on your learning goals.
