# AMPL
AMPL (A Mathematical Programming Language) is an algebraic modeling language to describe and solve high-complexity problems for large-scale mathematical computing (e.g. large-scale optimization and scheduling-type problems).
## Required files
- `file.mod`: Main model file.
  * *How it works:* This file contains the descriptions of the parameters, sets and all the mathematical formulas necessary to solve the problem
- `file.dat`: Data file containing input data.
  * *How it works:* This file contains the input data needed to run the model. They must match the parameters contained in the file.mod
- `file.run`: Execution/run file for the model.
  * *How it works:* This file contains the information about which solver to use and which calculations to show at the end
`
