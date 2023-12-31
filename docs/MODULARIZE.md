# Modularization
- app 
  - this is the app module that builds the application

- ui
  - presentation
    - handles all the UI logic
  - design-system
    - handles all UI related design elements

- features
  - recipe search
  - recipe details

- data 
  - should know where to fetch the data from
  - domain
    - should describe how the data should be fetch for the UI
  - aggregator
    - should figure out if I need data from what source

- data-sources
  - remote
    - this is the data from the api
    - DTO (from API to APP)
  - local
    - this is the data stored locally (cached)
    - Entity (from local storage to APP)