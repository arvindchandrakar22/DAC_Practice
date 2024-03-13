import axios from 'axios'
import React, { useEffect, useState } from 'react'
import DataTable from 'react-data-table-component'
import { ToastContainer, toast } from 'react-toastify'
import { Button, Col, Dropdown, DropdownItem, DropdownMenu, DropdownToggle, Row } from 'reactstrap'

export default function StudentTable()
{
    const[students, setStudents]=useState([])
    const[currentPage, setCurrentPage]=useState(1)
    const[perPage, setPerPage]=useState(10)
    const[totalPages, setTotalPages]=useState(9)
    const[searchQuery, setSearchQuery] = useState('')
    const[dropDownOpen, setDropDownOpen] = useState('')
    const[filterAttribute, setFilterAttribute] = useState('')

    useEffect(()=>{
        //fetchStudentDetails();
        handleFilterSubmit();
    },[currentPage]);

    const fetchStudentDetails = async () => {
        try{
            const response = await axios.get('http://localhost:7777/api/details',{
                params:{
                    pageNmber : currentPage-1,
                    pageSize : perPage
                }
            });
            setStudents(response.data);
        } catch(error){
            console.error('Error Fetching Data !!',error)
        }
    }

    const handlePageChange = (page) => {
        console.log(page);
        setCurrentPage(page);
    }

    const handDropDownToggle = () => {
        setDropDownOpen(!dropDownOpen)
    }

    const handFilterChange = (attribute) => {
        setFilterAttribute(attribute)
        setSearchQuery('')
        setCurrentPage(1)
    }

    const handleSearch = event => {
        setSearchQuery(event.target.value)
        setCurrentPage(1)
    }

    const handleFilterSubmit = async () => {
        if(searchQuery!=='')
        {
            try{
                const response = await axios.get(`http://localhost:7777/api/${filterAttribute}/${searchQuery}`,{
                    params:{
                        pageNmber : currentPage-1,
                        pageSize : perPage
                    }
                });
                setStudents(response.data);
                toast.success("success");
            } catch(error){
                console.error('Error Fetching Data !!',error)
                toast.error("error")
            }
        }
        else{
            fetchStudentDetails();
        }
    }

    const columns = [
        {
            name : 'ID',
            selector : 'id',
            sortable : true
        },
        {
            name : 'NAME',
            selector : 'name',
            sortable : true
        },
        {
            name : 'AGE',
            selector : 'age',
            sortable : true
        },
        {
            name : 'GENDER',
            selector : 'gender',
            sortable : true
        },
        {
            name : 'BRANCH',
            selector : 'branch',
            sortable : true
        },
        {
            name : 'PASS OUT YEAR',
            selector : 'passOutYear',
            sortable : true
        },
        {
            name : 'CITY',
            selector : 'city',
            sortable : true
        },
        {
            name : 'STATE',
            selector : 'state',
            sortable : true
        },
        {
            name : 'EXPERENCE',
            selector : 'experience',
            sortable : true
        }
    ];


  return (
    <div>
        <Row>
            <Col className='col-sm-2'>
        <Dropdown isOpen={dropDownOpen} toggle={handDropDownToggle}>
            <DropdownToggle caret>Filter By</DropdownToggle>
            <DropdownMenu>
                <DropdownItem onClick={() => handFilterChange('City')}>CITY</DropdownItem>
                <DropdownItem onClick={() => handFilterChange('Branch')}>BRANCH</DropdownItem>
                <DropdownItem onClick={() => handFilterChange('Age')}>AGE</DropdownItem>
                <DropdownItem onClick={() => handFilterChange('Experience')}>EXPERIENCE</DropdownItem>
                <DropdownItem onClick={() => handFilterChange('PassOutYear')}>PASS OUT YEAR</DropdownItem>
                <DropdownItem onClick={() => handFilterChange('Gender')}>GENDER</DropdownItem>
            </DropdownMenu>
        </Dropdown>
        </Col>

        <Col>
        <input className='col-sm-12'
        type='text'
        placeholder='search here'
        value={searchQuery}
        onChange={handleSearch}
        />
        </Col>

        <Col className='col-sm-2'>
        <Button onClick={handleFilterSubmit}>Apply Filter</Button>
        </Col>

        </Row>
        <DataTable
        table=""
        columns={columns}
        data={students}
        pagination
        paginationServer
        onChangePage={handlePageChange}
        paginationTotalRows={totalPages*perPage}
        paginationPerPage={perPage}
        paginationComponentOptions={
            {noRowsPerPage:true}
        }
        paginationActivePage = {currentPage}
        />
        <ToastContainer />
    </div>
  )
}
