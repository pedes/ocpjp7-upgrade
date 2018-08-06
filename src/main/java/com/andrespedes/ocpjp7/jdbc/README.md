#JDBC  Remarks

One of the most important theory parts of the certification is the JDBC Rowset interface hierarchy.

- Resulset is the most general interface
- Rowset inherits from Resultset
- JdbcRowSet inherits from Rowset, is connected always to the DB and plus all Java Bean Capabilities
- CachedRowSet inherits from Rowset, is almost the same as JdbcRowSet but this is a disconnected interface.
- WebRowSet inherits from CachedRowSet, adds the XML capabilities
- JoinRowSet inherits from WebRowSet, adds SQL Join capabilities
- FilteredRowSet inherits from WebRowset, adds filtering capabilities

>Rowset <- JdbcRowset, CachedRowset <- WebRowset <- JoinRowSet, FilteredRowset

This is the acronym for the interfaces that inherint from Rowset, **JCWJF**

>JDBC 4.1 introduces the capability to use try-with-resources statement to close resources (Connection, ResultSet, and Statement) automatically.

- The columns in a resultset start at index 1, not at 0 (zero) as arrays.
- (Any attempt to use methods such as commit, rollback, setSavepoint, etc. will result in throwing a
  SQLException if auto-commit is not disabled.)
-
