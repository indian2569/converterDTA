# converterDTA
Simple converter from DTA file to CSV.  

Project consist JAR file of project and runable bat file 

In Bat file you can set up yours path from where read dta file and where to save them

Program need 2 input parameters to run: 

1. path from where he need to read files
2. path where to save converted files

Example 
set inputLocation="C:\files"
set outputLocation="D:\testFolder"

JAR file can be run like this 

java -cp converterDTA.jar com.karumien.conventer.ConverterController %inputLocation% %outputLocation%
