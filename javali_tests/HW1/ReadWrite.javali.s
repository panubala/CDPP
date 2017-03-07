  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 5
          # Emitting i0
          addl $-4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = read()
          # Emitting i1
          addl $-4, %esp
          # Emitting read()
          pushl %esp
          call _scanf
          movl 0(%esp), %esi
        movl %esi, -8(%ebp)
<<<<<<< HEAD
        # Emitting write(i1)
          # Emitting i1
          movl -8(%ebp), %edi
        pushl %edi
        call _printf
=======
        # Emitting r1 = (i0 + i1)
          # Emitting r1
          movl -36(%ebp), %edi
          # Emitting (i0 + i1)
            # Emitting i0
            movl -4(%ebp), %esi
            # Emitting i1
            movl -8(%ebp), %edx
          pushl %esi
          pushl %edx
          movl 4(%esp), %esi
          addl 0(%esp), %esi
        movl %esi, -36(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -36(%ebp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
        # Emitting write((r1 - 3))
          # Emitting (r1 - 3)
            # Emitting r1
            movl -36(%ebp), %edi
            # Emitting 3
            movl $3, %esi
          pushl %edi
          pushl %esi
          movl 4(%esp), %edi
          subl 0(%esp), %edi
        pushl %edi
        call _printf
        # Emitting writeln()
        pushl $.LC1
        call _printf
    movl %ebp, %esp
>>>>>>> 863530a4320df1f0a3dcaa072a5c43369f5a1b1f
    movl $0, %eax
    popl %ebp
    ret
