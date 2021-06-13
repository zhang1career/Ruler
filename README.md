# Rule Engine


## 2. Mechanism
### 2.1. Calculation
The rule engine is powered by abstract-symbol-tree (AST) calculation.

### 2.2. Optimization
By following optimization, the processing speed has been increased by at least 1.6X<sup>`*`</sup>.

#### 2.2.1. Caching
    * caching operations in memory

    * caching result of calculations

#### 2.2.2. Parallel calculation
* directed-acyclic-graph (DAG) sorting

* recursion-iteration conversion

* parallel calculation (TODO)


---
`*` The SUT has 4 AST level, each level has 5 branches of reusable operations.