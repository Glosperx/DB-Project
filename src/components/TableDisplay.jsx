import React, { useState, useEffect } from "react";
import axios from "axios";

const TableDisplay = ({ tableName, sortColumn, sortDirection }) => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");
  const [editingRow, setEditingRow] = useState(null);
  const [editedData, setEditedData] = useState({});
  const [originalData, setOriginalData] = useState({});
  const [insertData, setInsertData] = useState({});
  const [showInsertForm, setShowInsertForm] = useState(false);

  // Fetch data from backend
  useEffect(() => {
    if (tableName) {
      setLoading(true);
      const sortQuery = sortColumn && sortDirection
        ? `/${sortColumn}${sortDirection === "asc" ? "Asc" : "Desc"}`
        : '';

      axios
        .get(`http://localhost:8080/${tableName}${sortQuery}`)
        .then((response) => {
          setData(response.data);
          setLoading(false);
        })
        .catch((error) => {
          console.error("Eroare la preluarea datelor:", error);
          setErrorMessage("Eroare la preluarea datelor.");
          setLoading(false);
        });
    }
  }, [tableName, sortColumn, sortDirection]);

  // Handle edit
  const handleEdit = (row) => {
    setEditingRow(row.id);
    setEditedData(row);
    setOriginalData(row);
  
    
    if (tableName === "componente_pachet") {
      setEditedData({
        ...row,
        id_element: row.id_element || '', 
        id_pachet: row.id_pachet || '', 
      });
    } else if (tableName === "comenzi_pachet") {
      setEditedData({
        ...row,
        id_comanda: row.id_comanda || '', 
        id_pachet: row.id_pachet || '', 
      });
    }
  };

  // Handle input change for editing
  const handleChange = (event, field) => {
    let value = event.target.value;
  
    // Listele de câmpuri numerice
    const integerFields = ["ID_CLIENT", "ID_COMANDA", "ID_MOTOR", "ID_CULOARE", "ID_ROTI", "ID_PACHET", "ID_ELEMENT"];
    const doubleFields = ["PUTERE", "PRET_MOTOR", "PRET_CULOARE", "DIMENSIUNE_ROTI", "PRET_ROTI", "PRET_PACHET", "PRET_BAZA", "GREUTATE", "REDUCERE"];
  
    if (integerFields.includes(field)) {
      value = parseInt(value, 10) || "";
    } else if (doubleFields.includes(field)) {
      value = parseFloat(value) || "";
    }
  
    setEditedData({
      ...editedData,
      [field]: value,
    });
  };
  

  // Handle save
  const handleSubmit = () => {
    let url = `http://localhost:8080/${tableName}`;
  
    if (tableName === "componente_pachet") {
      url += `/${editedData.id_element}/${editedData.id_pachet}`;
    } else if (tableName === "comenzi_pachet") {
      url += `/${editedData.id_comanda}/${editedData.id_pachet}`;
    } else {
      url += `/${editedData.id}`;
    }
  
    axios
      .put(url, editedData)
      .then(() => {
        setData(data.map((item) =>
          item.id === editedData.id ? editedData : item
        ));
        setEditingRow(null);
        alert(`Elementul a fost actualizat cu succes.`);
      })
      .catch((error) => {
        setErrorMessage("A apărut o eroare la actualizarea elementului. Verificați backend-ul.");
        console.error("Eroare la actualizarea elementului:", error);
      });
  };

  // Handle cancel
  const handleCancel = () => {
    setEditedData(originalData);
    setEditingRow(null);
  };

  // Handle delete
  const handleDelete = (id) => {
    console.log("ID primit pentru ștergere:", id);
    let url = `http://localhost:8080/${tableName}/delete/${id}`;
  
    if (tableName === "componente_pachet") {
      url = `http://localhost:8080/${tableName}/delete/${editedData.id_element}/${editedData.id_pachet}`;
    } else if (tableName === "comenzi_pachet") {
      url = `http://localhost:8080/${tableName}/delete/${editedData.id_comanda}/${editedData.id_pachet}`;
    }
  
    axios
      .delete(url)
      .then(() => {
        setData(data.filter((item) => item.id !== id));
        alert(`Elementul cu id ${id} a fost șters cu succes.`);
      })
      .catch((error) => {
        setErrorMessage("A apărut o eroare la ștergerea elementului. Verificați backend-ul.");
        console.error("Eroare la ștergerea elementului:", error);
      });
  };

  // Handle insert
  const handleInsertSubmit = () => {
    axios
      .post(`http://localhost:8080/${tableName}/add`, insertData)
      .then((response) => {
        setData([...data, response.data]);
        alert(`Elementul a fost adăugat cu succes.`);
        setInsertData({});
        setShowInsertForm(false);
      })
      .catch((error) => {
        setErrorMessage("Eroare la inserarea elementului.");
        console.error("Eroare la inserare:", error);
      });
  };

  // Handle insert form input change
  const handleInsertChange = (event, field) => {
    const value = event.target.value;
    setInsertData({
      ...insertData,
      [field]: value,
    });
  };

  // Toggle insert form visibility
  const toggleInsertForm = () => {
    setShowInsertForm(!showInsertForm);
  };

  // Render table
  const renderTable = () => {
    if (data.length === 0) {
      return <p>Nu sunt date pentru acest tabel.</p>;
    }

    const headers = Object.keys(data[0]);

    const idColumns = headers.filter((header) => header.toLowerCase().includes("id"));
    const sortedHeaders = [...idColumns, ...headers.filter(header => !header.toLowerCase().includes("id"))];
    const sortedData = data.map(row => {
      const idValues = {};
      const rest = {};

      sortedHeaders.forEach(header => {
        if (idColumns.includes(header)) {
          idValues[header] = row[header];
        } else {
          rest[header] = row[header];
        }
      });

      return { ...idValues, ...rest };
    });

    return (
      <div className="table-container">
        <table border="1" cellPadding="5" cellSpacing="0">
          <thead>
            <tr>
              {sortedHeaders.map((header) => (
                <th key={header}>{header}</th>
              ))}
              <th>Acțiune</th>
            </tr>
          </thead>
          <tbody>
            {sortedData.map((row, index) => {
              const primaryKey = Object.keys(row).find((key) => key.startsWith("ID_")); // Găsește cheia primară
              return (
                <tr key={index}>
                  {sortedHeaders.map((header) => (
                    <td key={header}>
                      {editingRow === row[primaryKey] ? (
                        <input
                          type="text"
                          value={editedData[header] || ""}
                          onChange={(e) => handleChange(e, header)}
                        />
                      ) : (
                        row[header]
                      )}
                    </td>
                  ))}
                  <td>
                    <button onClick={() => handleDelete(row[primaryKey])}>Șterge</button>
                    {editingRow !== row[primaryKey] ? (
                      <button onClick={() => handleEdit(row)}>Editează</button>
                    ) : (
                      <>
                        <button onClick={handleSubmit}>Salvează</button>
                        <button onClick={handleCancel}>Cancel</button>
                      </>
                    )}
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    );
  };

  // Render insert form
  const renderInsertForm = () => {
    if (showInsertForm) {
      return (
        <div>
          <h3>Adăugați un nou element în {tableName}</h3>
          <form>
            {Object.keys(data[0] || {}).map((key) => (
              <div key={key}>
                <label>{key}:</label>
                <input
                  type="text"
                  value={insertData[key] || ""}
                  onChange={(e) => handleInsertChange(e, key)}
                />
              </div>
            ))}
            <button type="button" onClick={handleInsertSubmit}>
              Adaugă
            </button>
          </form>
        </div>
      );
    }
    return null;
  };

  if (loading) {
    return <p>Se încarcă datele...</p>;
  }

  return (
    <div>
      <h2>Informații din tabelul: {tableName}</h2>
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      <button onClick={toggleInsertForm}>
        {showInsertForm ? "Anulează adăugarea" : "Adaugă un element"}
      </button>
      {renderInsertForm()}
      {renderTable()}
    </div>
  );
};

export default TableDisplay;