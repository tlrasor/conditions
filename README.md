conditions
==========

Simple runtime design by contract DSL written in [groovy].

This library implements a simple DSL to help support [Design by Contract], similar 
to [guava's Preconditions class] or [Microsoft Research's Code Contracts] library.

## Usage

Conditions is a fluent API for doing design by contract like conditions. Unlike many Java ecosystem DbC frameworks, conditions is not based on static methods and assert statements and but is instead fully object oriented and uses regular Java exceptions to signal errors. This aspect allows it to better fit into a 'traditional' Java paradigm and makes the system very easy to reason about. Many frameworks are somewhat complicated, using annotations and clunky contexts, conditions is designed to be as simple and plain as possible.

Several different types of conditions are supported:

- Object
- Boolean
- Integer
- String
- Collection

It is trivial to add support for more classes by extending the ObjectCondition class.

Here are several examples of using the conditions DSL:

```groovy
// Simple boolean conditions are easy to construct
Condition.that((1+1)==2).isTrue()

// use try catches to recover from failures
def getConnection(Session s) {
    try {
        Condition.that(s.isOpen()).isTrue()
    } catch (ConditionViolationException e) {
        reopenSession(s)
        return getConnection(s)
    }
}

```

For more details, the unit tests section is fairly complete with examples of use for each of the supported condition types.

contracts uses Travis CI for [builds]

Copyright 2016 Travis Rasor [MIT License]([tldr])

[groovy]: https://github.com/apache/groovy
[Design by Contract]: http://en.wikipedia.org/wiki/Design_by_contract
[guava's Preconditions class]: https://code.google.com/p/guava-libraries/wiki/PreconditionsExplained
[Microsoft Research's Code Contracts]: http://research.microsoft.com/en-us/projects/contracts/
[builds]: (https://travis-ci.org/tlrasor/conditions)
[MIT License]: https://opensource.org/licenses/MIT
[tldr]: https://tldrlegal.com/license/mit-license