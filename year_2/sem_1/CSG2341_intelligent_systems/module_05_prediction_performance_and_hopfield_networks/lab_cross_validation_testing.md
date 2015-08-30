# CSG2341

## Workshop 5: Cross validation testing of a neural network for regression

#### Martin Ponce 10371381

## Attribute defintions

- PREC   Average annual precipitation in inches
- JANT   Average January temperature in degrees F
- JULT   Same for July
- OVR65  % of 1960 SMSA population aged 65 or older
- POPN   Average household size
- EDUC   Median school years completed by those over 22
- EDUC   Median school years completed by those over 22
- HOUS   % of housing units which are sound & with all facilities
- DENS   Population per sq. mile in urbanized areas, 1960
- NONW   % non-white population in urbanized areas, 1960
- WWDRK  % employed in white collar occupations
- POOR   % of families with income < $3000
- HC     Relative hydrocarbon pollution potential
- NOX    Same for nitric oxides
- SO@    Same for sulphur dioxide
- HUMID  Annual average % relative humidity at 1pm
- MORT   Total age-adjusted mortality rate per 100,000

## Target

- Least amount of attributes
- Converted test error score < 41.0

<div class="page-break"></div>

## Results

![Trained Network](http://snag.gy/Ww1RG.jpg)

### Attributes

- PREC
- NONW
- SO@

### Errors

| results   | train error | test error |
|-----------|-------------|------------|
| mean      | 0.013       | 0.016      |
| converted | 37.388      | 40.428     |
