import Navbar from "../../components/dashboard/Navbar";
import Sidebar from "../../components/dashboard/Sidebar";

function AddPendidikan(){
    return (
        <>
          <div id="wrapper">
            <Sidebar />
    
            <div id="content-wrapper" className="d-flex flex-column">
              <div id="content">
                <Navbar />
    
                <div className="container-fluid">
                    AddPendidikanComponent
                </div>
              </div>
            </div>
          </div>
        </>
      );
    
}

export default AddPendidikan;