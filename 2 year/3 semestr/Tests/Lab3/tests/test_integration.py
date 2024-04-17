from main import run_command
from database import StudentDatabase

def test_add():
    db = StudentDatabase()
    assert run_command(db, "add 1 Tom")
    assert len(db.list()) == 1
    assert db.list()[0].name == "Tom"

def test_remove():
    db = StudentDatabase()
    run_command(db, "add 1 Tom")
    assert run_command(db, "remove 1")
    assert len(db.list()) == 0

def test_update():
    db = StudentDatabase()
    run_command(db, "add 1 Mark")
    assert run_command(db, "update 1 Anna")
    assert db.list()[0].name == "Anna"