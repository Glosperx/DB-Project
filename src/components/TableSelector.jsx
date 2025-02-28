import React, { useState } from "react";
import TableDisplay from "./TableDisplay";

const TableSelector = () => {
  const [selectedTable, setSelectedTable] = useState("client");
  const [selectedColumn, setSelectedColumn] = useState("");
  const [sortDirection, setSortDirection] = useState("asc");

  const [deleteId, setDeleteId] = useState("");
  const [updateData, setUpdateData] = useState({});

  // Lista tabelelor disponibile
  const tables = [
    "client",
    "comanda",
    "motor",
    "culoare",
    "roti",
    "pachet_echipare",
    "elemente_pachet",
    "componente_pachet",
    "kart",
    "comenzi_pachet",
  ];

  // Handler pentru schimbarea tabelului selectat
  const handleTableChange = (e) => {
    setSelectedTable(e.target.value);
    setSelectedColumn(""); // Resetează coloana de sortare la schimbarea tabelului
    setSortDirection("asc"); // Resetează direcția de sortare la schimbarea tabelului
  };

  // Handler pentru schimbarea coloanei de sortare
  const handleSortColumnChange = (e) => {
    setSelectedColumn(e.target.value);
  };

  // Handler pentru schimbarea direcției de sortare
  const handleSortDirectionChange = (e) => {
    setSortDirection(e.target.value);
  };

  // Handler pentru ștergerea unui rând
  const handleDelete = async () => {
    const url = `http://localhost:8080/${selectedTable}/delete/${deleteId}`;
    const response = await fetch(url, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (response.ok) {
      alert("Deleted successfully!");
    } else {
      alert("Error deleting the record.");
    }
  };

  // Handler pentru actualizarea unui rând
  const handleUpdate = async () => {
    let url = "";
    let body = {};
  
    if (selectedTable === "kart") {
      url = `http://localhost:8080/${selectedTable}/update/${deleteId}`;
      body = JSON.stringify({
        nume: updateData.nume,
        putere: parseFloat(updateData.putere),
        tip_motor: updateData.tip_motor,
      });
    } else if (selectedTable === "pachet_echipare") {
      url = `http://localhost:8080${selectedTable}/update/${deleteId}`;
      body = JSON.stringify({
        componenta: updateData.componenta,
        pret: parseFloat(updateData.pret),
      });
    } else if (selectedTable === "client") {
      url = `http://localhost:8080/${selectedTable}/update/${deleteId}`;
      body = JSON.stringify({
        nume: updateData.nume,
        email: updateData.email,
        telefon: updateData.telefon,
      });
    } else if (selectedTable === "comanda") {
      url = `http://localhost:8080/${selectedTable}/update/${deleteId}`;
      body = JSON.stringify({
        data: updateData.data,
        total: parseFloat(updateData.total),
        status: updateData.status,
      });
    } else if (selectedTable === "plata") {
      url = `http://localhost:8080/${selectedTable}/update/${deleteId}`;
      body = JSON.stringify({
        metoda: updateData.metoda,
        suma: parseFloat(updateData.suma),
      });
    }
  
    const response = await fetch(url, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body,
    });
  
    if (response.ok) {
      alert("Actualizat cu succes!");
    } else {
      alert("Eroare la actualizare.");
    }
  };
  

  return (
    <div>
      <h1>Alege un tabel</h1>
      <select onChange={handleTableChange} value={selectedTable}>
        {tables.map((table, index) => (
          <option key={index} value={table}>
            {table}
          </option>
        ))}
      </select>

      <h3>Alege coloana de sortat</h3>
      <select onChange={handleSortColumnChange} value={selectedColumn}>
        <option value="">Selectează coloana</option>
        {selectedTable === "client" && (
          <>
            <option value="ID_Client">ID Client</option>
            <option value="Nume">Nume</option>
            <option value="Prenume">Prenume</option>
            <option value="Email">Email</option>
            <option value="Telefon">Telefon</option>
            <option value="Tara_provenienta">Țara proveniență</option>
          </>
        )}
        {selectedTable === "comanda" && (
          <>
            <option value="ID_Comanda">ID Comandă</option>
            <option value="Metoda_Plata">Metodă plată</option>
            <option value="Oras_Livrare">Oraș livrare</option>
            <option value="ID_Client">ID Client</option>
          </>
        )}
        {selectedTable === "motor" && (
          <>
            <option value="ID_Motor">ID Motor</option>
            <option value="Tip_Motor">Tip Motor</option>
            <option value="Capacitate_cilindrica">Capacitate cilindrică</option>
            <option value="Putere">Putere</option>
            <option value="Pret_Motor">Preț Motor</option>
          </>
        )}
        {selectedTable === "culoare" && (
          <>
            <option value="ID_Culoare">ID Culoare</option>
            <option value="Nume_Culoare">Nume Culoare</option>
            <option value="Pret_Culoare">Preț Culoare</option>
            <option value="Tip_Finisaj">Tip Finisaj</option>
          </>
        )}
        {selectedTable === "roti" && (
          <>
            <option value="ID_Roti">ID Roți</option>
            <option value="Dimensiune_Roti">Dimensiune Roți</option>
            <option value="Culoare_Roti">Culoare Roți</option>
            <option value="Denumire_Roti">Denumire Roți</option>
            <option value="Pret_Roti">Preț Roți</option>
          </>
        )}
        {selectedTable === "kart" && (
          <>
            <option value="ID_Kart">ID Kart</option>
            <option value="Pret_Baza">Preț Bază</option>
            <option value="Nume_Model">Nume Model</option>
            <option value="Greutate">Greutate</option>
            <option value="ID_Motor">ID Motor</option>
            <option value="ID_Culoare">ID Culoare</option>
            <option value="ID_Roti">ID Roți</option>
            <option value="ID_Pachet">ID Pachet</option>
          </>
        )}
      </select>

      <h3>Alege direcția de sortare</h3>
      <select onChange={handleSortDirectionChange} value={sortDirection}>
        <option value="asc">Crescător</option>
        <option value="desc">Descrescător</option>
      </select>

      {/* Secțiune pentru ștergere și actualizare */}
      <div>
        <h3>Șterge sau actualizează un rând</h3>
        <input
          type="text"
          placeholder="ID rând"
          value={deleteId}
          onChange={(e) => setDeleteId(e.target.value)}
        />
        <button onClick={handleDelete}>Șterge</button>

        <h3>Actualizează un rând</h3>
        {selectedTable === "kart" && (
          <>
            <input
              type="text"
              placeholder="Nume Model"
              value={updateData.Nume_Model || ""}
              onChange={(e) =>
                setUpdateData({ ...updateData, Nume_Model: e.target.value })
              }
            />
            <input
              type="number"
              placeholder="Preț Bază"
              value={updateData.Pret_Baza || ""}
              onChange={(e) =>
                setUpdateData({ ...updateData, Pret_Baza: e.target.value })
              }
            />
          </>
        )}
        <button onClick={handleUpdate}>Actualizează</button>
      </div>

      {/* Afișează tabelul */}
      <TableDisplay
        tableName={selectedTable}
        sortColumn={selectedColumn}
        sortDirection={sortDirection}
      />
    </div>
  );
};

export default TableSelector;