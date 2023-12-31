# Modularization
- app 
  - this is the app module that builds the application

- presentation
  - handles all the UI logic

- features
  - recipe search
  - recipe details

- data 
  - should know where to fetch the data from
  - domain
    - should describe how the data should come as
  - aggregator
    - should figure out if I need data from what source

- data-sources
  - remote
    - this is the data from the api
  - local
    - this is the data stored locally (cached)