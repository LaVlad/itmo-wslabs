# Usage

1. Execute  ```mvn clean package -P <profile>``` 

    |   lab # |        profile | description |
    |:-------:|:--------------|:---|
    |   1     | lab-1-standalone | Standalone implementation |
    |   1     | lab-1-j2ee      | J2EE Tomee based implementation |
    |   2     | lab-2 |  |
    |   3     | lab-3 |  |
    |   4     | lab-4 |  |
    |   5     | lab-5 |  |
    |   6     | lab-6 |  |
    |   7     | lab-7 |  |

2. Execute ```run.bat``` script
3. Execute ```java -jar wslab-client.jar```.    
   Use flags to filter output:
   
    |  flag  | description |
    |:--------:|:---|
    |   -i     | Filter by index |
    |   -t     | Filter by title |
    |   -a     | Filter by author |
    |   -p     | Filter by number of pages |
    |   -s     | Filter by synopsis |

    In lab2 and lab3, use following commands as arguments:

   |  command  | description |
   |:--------:|:---|
   |   get     | Get existing entries of database. Works with flags above. |
   |   create     | Create new database entry. Use flags above to specify field values. |
   |   delete     | Delete database entry. -i flag required to specify ID of entry to be deleted. |
   |   update     | Update database entry. Use flags above to specify new field values. |

# Example
1. ```mvn clean package -P lab-2```
2. ```run.bat```
3. ```java -jar wslab-client.jar get```

# Lab 7 execution and testing
1. `mvn clean package -P lab-7`
2. run the `run_juddi.sh` script
3. To create new service: `java -jar wslab-client.jar create -b 'your_business_name' -s 'your_service_name'`
4. To get previously created service: `java -jar wslab-client.jar get -n 'your_service_name'`