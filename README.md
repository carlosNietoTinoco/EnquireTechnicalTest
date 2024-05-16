## Test Application

##Requirements:

To run this application, it's necessary to have Docker installed, version 19.03 or higher. You must have the following ports available:

56790
56791
56792
56793

##Deployment Instructions:

Unzip the EnquireTechnicalTest.zip file. Enter the generated folder and open a terminal located in that folder. Execute the following command:

docker compose up

This command will execute all the necessary software components for the project. On my computer, it took around 10 minutes. I apologize for its length, partly due to downloading Phi-3, which weighs 2.3 GB.

When all the necessary software has finished running, you'll see the following outputs on the screen:

Last 2 lines of the ai-api container:

ai-api | * Debugger is active!
ai-api | * Debugger PIN: 317-285-571

Last 5 lines of the adn-app container:

adn-app | 2024-05-16 04:08:54.852 INFO 1 --- [ main] o.s.s.concurrent.ThreadPoolTaskExecutor : Initializing ExecutorService 'applicationTaskExecutor'
adn-app | 2024-05-16 04:08:54.904 WARN 1 --- [ main] aWebConfiguration$JpaWebMvcConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
adn-app | 2024-05-16 04:08:55.178 INFO 1 --- [ main] o.s.b.a.e.web.EndpointLinksResolver : Exposing 2 endpoint(s) beneath base path '/actuator'
adn-app | 2024-05-16 04:08:55.233 INFO 1 --- [ main] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat started on port(s): 8080 (http) with context path '/api/v1'
adn-app | 2024-05-16 04:08:55.235 INFO 1 --- [ main] com.carvajal.adn.AdnApplication : Started AdnApplication in 6.39



At this point, you can go to:

http://localhost:56793/

The result consists of 2 parts. The first one displays the AI's text response, and the second one shows the matches found.

There you'll find a text entry, where you can input a fragment from any of the following articles. In approximately 1 minute and 20 seconds, the program will indicate the search result below the text box.


https://repositorio.iiap.gob.pe/handle/20.500.12921/749
https://repositorio.iiap.gob.pe/handle/20.500.12921/748
https://repositorio.iiap.gob.pe/handle/20.500.12921/746
https://repositorio.iiap.gob.pe/handle/20.500.12921/745
https://repositorio.iiap.gob.pe/handle/20.500.12921/744
https://repositorio.iiap.gob.pe/handle/20.500.12921/743
https://repositorio.iiap.gob.pe/handle/20.500.12921/742
https://repositorio.iiap.gob.pe/handle/20.500.12921/741
https://repositorio.iiap.gob.pe/handle/20.500.12921/740
https://repositorio.iiap.gob.pe/handle/20.500.12921/737
https://repositorio.iiap.gob.pe/handle/20.500.12921/736
https://repositorio.iiap.gob.pe/handle/20.500.12921/735
https://repositorio.iiap.gob.pe/handle/20.500.12921/733
https://repositorio.iiap.gob.pe/handle/20.500.12921/731
https://repositorio.iiap.gob.pe/handle/20.500.12921/730
https://repositorio.iiap.gob.pe/handle/20.500.12921/729
https://repositorio.iiap.gob.pe/handle/20.500.12921/722
https://repositorio.iiap.gob.pe/handle/20.500.12921/721
https://repositorio.iiap.gob.pe/handle/20.500.12921/720
https://repositorio.iiap.gob.pe/handle/20.500.12921/719








