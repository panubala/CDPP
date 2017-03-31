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
        # Emitting A = 1
          # Emitting 1
          movl $1, %edi
          # Emitting A
          subl $4, %esp
        movl %edi, -4(%ebp)
        # Emitting B = 1
          # Emitting 1
          movl $1, %esi
          # Emitting B
          subl $4, %esp
        movl %esi, -8(%ebp)
        # Emitting a = (A * -(B))
          # Emitting (A * -(B))
            # Emitting -(B)
              # Emitting B
              movl -8(%ebp), %edi
            negl %edi
            # Emitting A
            movl -4(%ebp), %esi
          imull %edi, %esi
          # Emitting a
          subl $4, %esp
        movl %esi, -12(%ebp)
        # Emitting b = (-(A) * B)
          # Emitting (-(A) * B)
            # Emitting -(A)
              # Emitting A
              movl -4(%ebp), %edi
            negl %edi
            # Emitting B
            movl -8(%ebp), %esi
          imull %esi, %edi
          # Emitting b
          subl $4, %esp
        movl %edi, -16(%ebp)
        # Emitting c = -((A + B))
          # Emitting -((A + B))
            # Emitting (A + B)
              # Emitting A
              movl -4(%ebp), %esi
              # Emitting B
              movl -8(%ebp), %edi
            addl %edi, %esi
          negl %esi
          # Emitting c
          subl $4, %esp
        movl %esi, -20(%ebp)
        # Emitting d = -((A * B))
          # Emitting -((A * B))
            # Emitting (A * B)
              # Emitting A
              movl -4(%ebp), %edi
              # Emitting B
              movl -8(%ebp), %esi
            imull %esi, %edi
          negl %edi
          # Emitting d
          subl $4, %esp
        movl %edi, -24(%ebp)
        # Emitting write(a)
          # Emitting a
          movl -12(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(b)
          # Emitting b
          movl -16(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(c)
          # Emitting c
          movl -20(%ebp), %esi
        pushl %esi
        pushl $.LC0
        call _printf
        addl $8, %esp
        # Emitting writeln()
        pushl $.LC1
        call _printf
        addl $4, %esp
        # Emitting write(d)
          # Emitting d
          movl -24(%ebp), %esi
        pushl %esi
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
