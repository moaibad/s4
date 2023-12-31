import React, { useEffect, useState, useContext } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Cookies from "js-cookie";

import { FaEye } from "react-icons/fa";
import { FaEdit } from "react-icons/fa";
import { FaTrash } from "react-icons/fa";

const ListDosen = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const userAuth = Cookies.get("userAuth");
  const userRole = Cookies.get("userRole");

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get("http://localhost:8082/dosen");
        setData(response.data);
        setLoading(false); // Set loading to false after data is fetched
        console.log("userAuth : " + userAuth);
        console.log("userRole : " + userRole);
      } catch (error) {
        console.error("Error fetching data:", error);
        setLoading(false); // Set loading to false on error
      }
    }
    fetchData();
  }, []);

  async function handleDelete(id_dosen) {
    const confirmDelete = window.confirm(
      "Apakah Anda yakin ingin menghapus data ini?"
    );
    if (!confirmDelete) {
      return;
    }
    try {
      // Kirim permintaan DELETE ke server dengan parameter id_dosen
      await axios.delete(
        `http://localhost:8082/dosen/delete?id_dosen=${id_dosen}`
      );
      // Perbarui tampilan dengan menghapus entitas dari state lokal
      setData((prevData) =>
        prevData.filter((dosen) => dosen.id_dosen !== id_dosen)
      );
      alert("Data dosen berhasil dihapus");
    } catch (error) {
      console.error("Error deleting data:", error);
    }
  }

  return (
    <div className="container">
      <h1 className="text-center p-3 m-3">Daftar Dosen</h1>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <div className="card shadow mb-4">
          <div className="card-header py-3 d-flex justify-content-end">
            <Link to="/dosen/insert" className="btn btn-outline-primary">Tambah Dosen</Link>
          </div>
          <div className="card-body">
            <div className="table-responsive">
              <table
                className="table table-bordered"
                id="dataTable"
                width="100%"
                cellSpacing="0"
              >
                <thead>
                  <tr>
                    <th>ID Dosen</th>
                    <th>ID User</th>
                    <th>NIDN</th>
                    <th>Email</th>
                    <th>Nama Lengkap</th>
                    <th>Jabatan Fungsional</th>
                    <th>Jurusan</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  {data.map((dosen) => (
                    <tr key={dosen.id_dosen}>
                      <td>{dosen.id_dosen}</td>
                      <td>{dosen.id_user}</td>
                      <td>{dosen.nidn}</td>
                      <td>{dosen.email}</td>
                      <td>{dosen.nama_lengkap}</td>
                      <td>{dosen.jabatan_fungsional}</td>
                      <td>{dosen.jurusan}</td>
                      <td>
                        <div className="d-flex justify-content-center">
                          {/* <Link to={{ pathname: `/dosen/edit/${dosen.id_dosen}` }}>
                              <button type="button" className="btn btn-primary">
                                <FaEye />
                              </button>
                            </Link> */}
                          <Link
                            to={{ pathname: `/dosen/edit/${dosen.id_dosen}` }}
                          >
                            <button type="button" className="btn btn-success">
                              <FaEdit />
                            </button>
                          </Link>
                          <button
                            className="btn btn-danger ml-2"
                            onClick={() => handleDelete(dosen.id_dosen)}
                          >
                            <FaTrash />
                          </button>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default ListDosen;
