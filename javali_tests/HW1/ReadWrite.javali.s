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
          subl $4, %esp
          # Emitting 5
          movl $5, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = read()
          # Emitting i1
          subl $4, %esp
          # Emitting read()
          subl $4, %esp
          pushl %esp
          pushl $.LC0
          call _scanf
          addl $8, %esp
          movl -12(%ebp), %esi
        movl %esi, -8(%ebp)
        # Emitting write(i1)
          # Emitting i1
          movl -8(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting r1 = (i0 + i1)
          # Emitting r1
          subl $4, %esp
          # Emitting (i0 + i1)
            # Emitting i0
            movl -4(%ebp), %esi
          pushl %esi
            # Emitting i1
            movl -8(%ebp), %esi
          movl -20(%ebp), %edx
          addl $4, %esp
          addl %esi, %edx
        movl %edx, -16(%ebp)
        # Emitting write(r1)
          # Emitting r1
          movl -16(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write((r1 - 3))
          # Emitting (r1 - 3)
            # Emitting r1
            movl -16(%ebp), %edi
          pushl %edi
            # Emitting 3
            movl $3, %edi
          movl -20(%ebp), %edx
          addl $4, %esp
          subl %edi, %edx
        pushl %edx
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
