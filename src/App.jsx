import React, { useState } from "react";
import TableSelector from "./components/TableSelector";
import TableDisplay from "./components/TableDisplay";

function App() {
  const [selectedTable, setSelectedTable] = useState(""); // Starea pentru tabelul selectat
  const [sortColumn, setSortColumn] = useState(""); // Starea pentru coloana de sortare
  const [sortDirection, setSortDirection] = useState("asc"); // Starea pentru direcția de sortare

  // Handler pentru schimbarea tabelului selectat
  const handleTableChange = (tableName) => {
    setSelectedTable(tableName);
    setSortColumn(""); // Resetează coloana de sortare la schimbarea tabelului
    setSortDirection("asc"); // Resetează direcția de sortare la schimbarea tabelului
  };

  // Handler pentru schimbarea coloanei de sortare
  const handleSortColumnChange = (column) => {
    setSortColumn(column);
  };

  // Handler pentru schimbarea direcției de sortare
  const handleSortDirectionChange = (direction) => {
    setSortDirection(direction);
  };

  return (
    <div className="App">
      <h1>Administrare Bază de Date</h1>
      {/* Componenta TableSelector */}
      <TableSelector
        onTableChange={handleTableChange}
        onSortColumnChange={handleSortColumnChange}
        onSortDirectionChange={handleSortDirectionChange}
      />
      {/* Componenta TableDisplay */}
      {selectedTable && (
        <TableDisplay
          tableName={selectedTable}
          sortColumn={sortColumn}
          sortDirection={sortDirection}
        />
      )}
    </div>
  );
}

export default App;