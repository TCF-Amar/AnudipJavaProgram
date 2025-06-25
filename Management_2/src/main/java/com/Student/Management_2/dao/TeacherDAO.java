package com.Student.Management_2.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.Management_2.models.Teacher;
import com.Student.Management_2.utils.HibernateUtils;

public class TeacherDAO {

	private static final Scanner sc = new Scanner(System.in);

	@SuppressWarnings("deprecation")
	public Boolean addTeacher(Teacher teacher) {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			// Check if a teacher with the same email already exists
			Teacher existingTeacher = session.createQuery("FROM Teacher WHERE email = :email", Teacher.class)
					.setParameter("email", teacher.getEmail()).uniqueResult();
			if (existingTeacher != null) {

				throw new RuntimeException("Teacher with email " + teacher.getEmail() + " already exists.");
			} else if (teacher.getName() == null || teacher.getName().isEmpty()) {
				throw new RuntimeException("Teacher name cannot be empty.");
			} else if (teacher.getEmail() == null || teacher.getEmail().isEmpty()) {
				throw new RuntimeException("Teacher email cannot be empty.");
			} else if (teacher.getPassword() == null || teacher.getPassword().isEmpty()) {
				throw new RuntimeException("Teacher password cannot be empty.");
			}

			session.save(teacher);
			return true;

				

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;

		} finally {
			if (tx != null) {
				tx.commit();
			}
			if (session != null) {
				session.close();
			}
		}
	}

//	get teacher by email
	public Teacher getTeacherByEmail(String email) {
		Session session = null;
		Teacher teacher = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			teacher = session.createQuery("FROM Teacher WHERE email = :email", Teacher.class)
					.setParameter("email", email).uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to retrieve teacher by email: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return teacher;
	}

//	get teacher list by name 
	public List<Teacher> getTeachersByName(String name) {
		Session session = null;
		List<Teacher> teachers = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			teachers = session.createQuery("FROM Teacher WHERE name LIKE :name", Teacher.class)
					.setParameter("name", "%" + name + "%").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to retrieve teachers by name: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return teachers;
	}

//	get teacher by ID
	public Teacher getTeacherById(int id) {
		Session session = null;
		Teacher teacher = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			teacher = session.get(Teacher.class, id);

			if (teacher == null) {
				throw new RuntimeException("Teacher with ID " + id + " not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException("Failed to retrieve teacher by ID: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return teacher;
	}

	// get all teachers

	public List<Teacher> getAllTeachers() {
		Session session = null;
		List<Teacher> teachers = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			teachers = session.createQuery("FROM Teacher", Teacher.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to retrieve all teachers: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return teachers;
	}

	@SuppressWarnings("deprecation")
	public Boolean updateTeacher(String email) {
		Transaction tx = null;
		Session session = null;
		try  {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();


			Teacher teacher = session.createQuery("FROM Teacher WHERE email = :email", Teacher.class)
					.setParameter("email", email).uniqueResult();

			if (teacher == null) {
				System.out.println("================================");
				return false;
			}

			// Name
			System.out.println("Enter new name for the teacher (current: " + teacher.getName() + "): ");
			String newName = sc.nextLine();
			if (newName != null && !newName.isEmpty()) {
				teacher.setName(newName);
			}

			// Email
			System.out.println("Enter new email for the teacher (current: " + teacher.getEmail() + "): ");
			String newEmail = sc.nextLine();
			if (newEmail != null && !newEmail.isEmpty()) {
				Teacher existingTeacher = session.createQuery("FROM Teacher WHERE email = :email", Teacher.class)
						.setParameter("email", newEmail).uniqueResult();

				if (existingTeacher != null) {
					System.out.println("----------------------------------------");
					System.out.println("Email " + newEmail + " is already in use.");
					System.out.println("----------------------------------------");

				}

				teacher.setEmail(newEmail);
			}

			// Password
			System.out.println("Enter new password for the teacher: ");
			String newPassword = sc.nextLine();
			if (newPassword != null && !newPassword.isEmpty()) {
				teacher.setPassword(newPassword);
			}

			session.update(teacher); 
			if (tx != null) {
				tx.commit();
			}
			
		return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace(); 
			return false;
		} finally {
			
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public Boolean deleteTeacher(int id) {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, id);
			if (teacher != null) {
				session.delete(teacher);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			System.out.println("================================");
			return false;
		} finally {
			if (tx != null) {
				tx.commit();
			}
			if (session != null) {
				session.close();
			}
		}
	}

}
