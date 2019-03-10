
# CaveTravel

Command line game about cave traveling.

##Features:
- Map travel
- Save / Load game
- Simply fights

##Requirements:
- JDK 8
- Maven 3.3.9

## Installation:
0. clone this repository
0. build: ```mvn install```
0. run: ```java -jar CaveTravel-1.0-SNAPSHOT.jar```

## How to play: 
- After run type "help" to see available commands.

## Developer comments:

###Assumptions
- open to extensions:
    + Engine, FightEngine, StoryTeller implementations should be easily substitution with existing once
    + New commands implementations should be added only in CaveFactory to start working.
    + Project could be even more expandable but it all depends on: what are the business requirements   
- easy to add new content: 
    + characters
    + monsters
    + places
- save/load feature, only pure Java (JAXB chosen) however there were picks: 
    + pure java - serializable, JAXB(removed in java 11), text parsers(worst pick)
    + JSON - e.g. jackson lib
    + size optimisations + fast (no human-readable)(best pick)- e.g. ProtoBuff, Avro 



Possible improvements:

- Tests - all classes should have unit tests (maybe without purely pojo) + E2E tests. Because of lack of time I choose to coverage only [SimpleEngineTest](/com.github.arkadiuss2.cavetravel.application.engine.core.SimpleEngineTest.java)
- CaveFactory change to Spring IOC
- System.out.println - could be changed to e.g. SomePrint.showMessage("message_key"). Class could for example get messages from properties file then show message in different language, persist it etc.
- Character/Place/Monster creator could be created/added via builder pattern.













